package br.com.bemobi.shortener;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bemobi.shortener.entity.Shorten;
import br.com.bemobi.shortener.service.ShortenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShortenerApplicationTests {

	@Autowired
	ShortenService shortenService;
	
	@SuppressWarnings("null")
	@Test
	public void contextLoads() {		
		List<Shorten>list = 	shortenService.findAll();			
		assertTrue(list!=null || list.size()<0);
	}
	
	

}
