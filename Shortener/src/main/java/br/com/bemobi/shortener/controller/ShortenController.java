package br.com.bemobi.shortener.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bemobi.shortener.entity.Shorten;
import br.com.bemobi.shortener.exception.ShortenException;
import br.com.bemobi.shortener.response.dto.ResponseErrorDTO;
import br.com.bemobi.shortener.service.ShortenService;

/**
 * 
 * @author Jefferson Leite
 *
 */
@RestController
public class ShortenController {
	
	@Autowired
	ShortenService service;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create( @RequestParam(value = "url", required = false) String url, @RequestParam(value = "alias", required = false) String alias) {
		Long initTime = getSystemTime();
		Shorten shorten = null;
		try {
			 shorten = service.shortenUrl(url, alias, initTime);	
		} catch (ShortenException e) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO(alias,e.getStatus().value(), e.getMessage() ), HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<Shorten>(shorten, HttpStatus.OK);
	}

	@RequestMapping(value = "/retrive", method = RequestMethod.GET)
	public ResponseEntity<Object> redirectToExternalUrl(@RequestParam(value = "alias", required = false) String alias) throws URISyntaxException {
		Long initTime = getSystemTime();//TODO:Propor um solução com AOP ou mais precisa!
		HttpHeaders httpHeaders=null;
		Shorten shorten=null;
		try {
			shorten = service.retriveUrl(alias);
	    	URI defaultUrl = new URI(shorten.getDefaultUrl());
		    httpHeaders = new HttpHeaders();
		    httpHeaders.setLocation(defaultUrl);
		    service.updateClick(shorten, initTime);
		} catch (ShortenException e) {
			return new ResponseEntity<>(new ResponseErrorDTO(alias,e.getStatus().value(), e.getMessage() ), HttpStatus.BAD_REQUEST );
		}
	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
	
	@RequestMapping(value = "/dashaboard", method = RequestMethod.GET)
	public ResponseEntity<?> dashaboard()  {
		List<Shorten>listShorten = new ArrayList<>();
		listShorten = service.findAll();
		if(listShorten==null || listShorten.isEmpty()){
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO(HttpStatus.BAD_REQUEST.value(),"No results found" ), HttpStatus.BAD_REQUEST );
		}
		
	    return new ResponseEntity<List<Shorten>>(listShorten, HttpStatus.SEE_OTHER);
	}
		
	private long getSystemTime() {
		return System.currentTimeMillis();
	}
}

