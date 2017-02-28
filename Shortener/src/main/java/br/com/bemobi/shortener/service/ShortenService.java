package br.com.bemobi.shortener.service;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.bemobi.shortener.entity.Shorten;
import br.com.bemobi.shortener.entity.Statistics;
import br.com.bemobi.shortener.exception.ShortenException;
import br.com.bemobi.shortener.repository.ShortenRepository;
import br.com.bemobi.shortener.util.UtilHash;
//import javax.transaction.Transactional;
import br.com.bemobi.shortener.util.UtilHttp;
/**
 * 
 * @author Jefferson Leite
 *
 */
@Service("shortenService")
public class ShortenService {

	
	@Autowired
	private ShortenRepository shortenRepository;
	@Autowired
	UtilHttp utilHttp;
	@Autowired
	UtilHash utilHash;
	

	@Transactional
	public Shorten shortenUrl(String url, String alias, Long initTime)throws ShortenException{
		
		validateUrl(url);
		Shorten shorten = null;
		if(StringUtils.isNotEmpty(alias)){
			shorten = shortenRepository.findOne(decodeAlias(alias));
		}else{
			shorten = shortenRepository.findByUrl(url);
		}
		if(shorten!=null){
			throw new ShortenException("CUSTOM ALIAS ALREADY EXISTS", HttpStatus.BAD_REQUEST, new IllegalArgumentException(alias));
		} 	
		
		Long endTime = getSystemTime();
		List<Statistics> listStatistic = new ArrayList<>();
		setStatistics(initTime, endTime, listStatistic);
		shorten = shortenRepository.save(new Shorten(url, listStatistic));
		shorten.setAlias(encodeAlias(shorten.getId()));
		shorten.setClick(0l);
		shorten.setUrl(url);			
		
		return shorten;
	}
	
	public Shorten retriveUrl(String alias) throws ShortenException {
		Shorten shorten = null;
		shorten = shortenRepository.findOne(decodeAlias(alias));
		if(shorten==null){
			throw new ShortenException("SHORTENED URL NOT FOUND", HttpStatus.BAD_REQUEST, new IllegalArgumentException(alias));
		}
		return shorten;
	}

	public List<Shorten>findTenMore(){
		return shortenRepository.queryFirst10Byclick(new PageRequest(0,2));
	}

	private void setStatistics(Long initTime, Long endTime, List<Statistics> listStatistic) {
		Statistics statistics = new Statistics(String.valueOf(endTime - initTime)+"ms");
		listStatistic.add(statistics);
	}


	private long getSystemTime() {
		return System.currentTimeMillis();
	}


	private String encodeAlias(Long alias) {		
		return utilHash.encrypt(alias);
	}

	private Long decodeAlias(String alias) {
		return utilHash.decryptForLong(alias);
	}
	
	
	private void validateUrl(String url) {
		if(!utilHttp.isValidUrl(url)){
			throw new ShortenException("Invalid URL", HttpStatus.BAD_REQUEST, new  MalformedURLException());
		}
		
	}

	
	@Transactional(dontRollbackOn=ShortenException.class)
	public Shorten delete(Long id) throws ShortenException {
		Shorten deletedShorten = shortenRepository.findOne(id);
		
		if (deletedShorten == null)
			throw new ShortenException("Error deleting record");
		
		shortenRepository.delete(deletedShorten);
		return deletedShorten;
	}

	@Transactional
	public List<Shorten> findAll() {
		return shortenRepository.findAll();
	}

	
	@Transactional(dontRollbackOn=ShortenException.class)
	public Shorten updateClick(Shorten shorten, Long initTime) throws ShortenException {
		Shorten updatedShorten = shortenRepository.findOne(shorten.getId());
		
		if (updatedShorten == null){
			throw new ShortenException("Error update record");
		}
		Long endTime = getSystemTime();
		Statistics statistics = new Statistics(String.valueOf(endTime - initTime)+"ms");
		shorten.getStatistics().add(statistics);
		updatedShorten.setClick(shorten.getClick()==null?1:shorten.getClick()+1);
		updatedShorten = shortenRepository.saveAndFlush(updatedShorten);
		
		return updatedShorten;
	}
	
	/*
	 * repo.findByAndSort("lannister", new Sort("firstname"));
	 * repo.findByAndSort("stark", new Sort("LENGTH(firstname)"));
	 * repo.findByAndSort("targaryen", JpaSort.unsafe("LENGTH(firstname)"));
	 * repo.findByAsArrayAndSort("bolton", new Sort("fn_len"));
	 */
}
