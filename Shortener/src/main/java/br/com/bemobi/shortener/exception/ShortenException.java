package br.com.bemobi.shortener.exception;

import org.springframework.http.HttpStatus;
/**
 * 
 * @author Jefferson Leite
 *
 */
public class ShortenException extends RuntimeException {

	private static final long serialVersionUID = 3226635632598650137L;
	
	private String message;
	private HttpStatus status;
	private Throwable cause;
	
	
	
	public ShortenException(String message) {
		super();
		this.message = message;
	}

	public ShortenException(String message, HttpStatus httpStatus, Throwable cause) {
		super(cause);
		this.status = httpStatus;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
