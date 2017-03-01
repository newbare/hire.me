package br.com.bemobi.shortener.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.bemobi.shortener.ShortenerApplication;

/**
 * 
 * @author Jefferson Leite
 *
 */
@Profile("test-unit")
@ActiveProfiles("test-unit")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortenerApplication.class)
@WebAppConfiguration
public class ShortenControllerTester {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();       
    }
	
	@Test
	public void shortenUrlWithoutAlias()throws Exception {		
		 mockMvc.perform(post("/create").param("url", "https://github.com/newbare/hire.me")).andExpect(status().isCreated());
	}
	
	@Test
	public void customAliasAlreadExists()throws Exception {		
		 mockMvc.perform(post("/create").param("url", "https://github.com/newbare/hire.me").param("alias", "jR")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void invalidUrl()throws Exception {		
		 mockMvc.perform(post("/create").param("url", "httpsol://github.com/newbare/hire.me").param("alias", "jR")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void shortenedUrlNotFound()throws Exception {		
		 mockMvc.perform(get("/retrive").param("alias", "jR1")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void shortenedUrlRedirect()throws Exception {		
		 mockMvc.perform(get("/retrive").param("alias", "jR")).andExpect(status().isSeeOther());
	}
	
	
	@Test
	public void top10NoResultsFound()throws Exception {		
		mockMvc.perform(get("/dashaboard")).andExpect(status().isOk());
	}
	
	
}

