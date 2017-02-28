package br.com.bemobi.shortener.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilHashTest {

	@Autowired
	UtilHash hs;
	
	@Test
	public void encoder(){
		
		assertEquals( "Mj3",hs.encrypt(123L) );
		assertEquals( "1lj",hs.encrypt(1234L) );
		assertEquals( "j0gW",hs.encrypt(12345L) );
		assertEquals( "xkNDJ",hs.encrypt(123456L) );
		assertEquals( "MW6vB",hs.encrypt(1234567L) );
		assertEquals( "1rQ2go",hs.encrypt(12345678L) );			
	}
	
	@Test
	public void decoder(){
		
		assertEquals( hs.decryptForLong("Mj3").longValue(), 123l );
		assertEquals( hs.decryptForLong("1lj").longValue(), 1234l );
		assertEquals( hs.decryptForLong("j0gW").longValue(), 12345l );
		assertEquals( hs.decryptForLong("xkNDJ").longValue(), 123456l );
		assertEquals( hs.decryptForLong("MW6vB").longValue(), 1234567l );
		assertEquals( hs.decryptForLong("1rQ2go").longValue(), 12345678l );			
	}
	
}
