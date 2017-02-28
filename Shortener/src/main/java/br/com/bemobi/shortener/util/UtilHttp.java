package br.com.bemobi.shortener.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;


@Component
public class UtilHttp {
	

	public  Boolean isValidUrl(String link){
		try {
		    URL url = new URL(link);
		    URLConnection conn = url.openConnection();
		    conn.connect();
		    return true;
		} catch (MalformedURLException e) {
		    return false;
		} catch (IOException e) {
		   return false;
		}
	}

	
	public  String getDomainName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public  String getUrlLessProtocol(String url) {
		int slashslash = url.indexOf("//") + 2;
		return url.substring(slashslash, (url.indexOf('/', slashslash) == -1)? url.length(): url.indexOf('/', slashslash));
	}

}
