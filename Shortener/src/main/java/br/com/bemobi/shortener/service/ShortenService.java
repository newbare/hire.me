package br.com.bemobi.shortener.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bemobi.shortener.entity.Shorten;
import br.com.bemobi.shortener.exception.ShortenNotFound;
import br.com.bemobi.shortener.repository.ShortenRepository;
//import javax.transaction.Transactional;

@Service("shortenService")
public class ShortenService {

	
	@Autowired
	private ShortenRepository shortenRepository;

	
	@Transactional
	public Shorten create(Shorten shorten) {
		Shorten createdShorten = shorten;
		return shortenRepository.save(createdShorten);
	}	
	
	@Transactional
	public Shorten findById(Long id) {
		return shortenRepository.findOne(id);
	}

	
	@Transactional(dontRollbackOn=ShortenNotFound.class)
	public Shorten delete(Long id) throws ShortenNotFound {
		Shorten deletedShorten = shortenRepository.findOne(id);
		
		if (deletedShorten == null)
			throw new ShortenNotFound();
		
		shortenRepository.delete(deletedShorten);
		return deletedShorten;
	}

	@Transactional
	public List<Shorten> findAll() {
		return shortenRepository.findAll();
	}

	
	@Transactional(dontRollbackOn=ShortenNotFound.class)
	public Shorten updateClick(Shorten shorten) throws ShortenNotFound {
		Shorten updatedShorten = shortenRepository.findOne(shorten.getIdUrl());
		
		if (updatedShorten == null)
			throw new ShortenNotFound();
		
		updatedShorten.setClick(shorten.getClick()+1);
		updatedShorten = shortenRepository.saveAndFlush(updatedShorten);
		
		return updatedShorten;
	}

	@Transactional
	public Boolean existesAlias(Long alias){
		return shortenRepository.findByAlias(alias)==null?false:true;
	}
	
	
}
