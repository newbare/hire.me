package br.com.bemobi.shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bemobi.shortener.service.ShortenService;


@RestController
@RequestMapping("/rest")
public class ShortenController {

	@Autowired
	ShortenService shortenService;
	
	
}
