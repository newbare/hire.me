package br.com.bemobi.shortener.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilHttpTest {

	@Autowired
	UtilHttp ht;
	
	@Test
	public void validateUrl(){
		assertTrue(ht.isValidUrl("http://globo.com.br"));
	}
		
	@Test
	public void getUrlLessProtocol(){
		assertEquals("globo.com.br", ht.getUrlLessProtocol("http://globo.com.br"));
		
	}
	
	@Test
	public void getDomain() throws URISyntaxException{
		assertEquals("globo.com.br",ht.getDomainName("http://globo.com.br"));
		
	}
}
