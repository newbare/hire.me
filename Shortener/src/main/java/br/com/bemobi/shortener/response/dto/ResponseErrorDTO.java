package br.com.bemobi.shortener.response.dto;
/**
 * 
 * @author Jefferson Leite
 *
 */
public class ResponseErrorDTO {

	private String alias;
	private int err_code;
	private String description;

	public ResponseErrorDTO(int err_code, String description) {
		this.err_code = err_code;
		this.description = description;
	}
	
	public ResponseErrorDTO(String alias, int err_code, String description) {
		super();
		this.alias = alias;
		this.err_code = err_code;
		this.description = description;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getErr_code() {
		return err_code;
	}

	public void setErr_code(int err_code) {
		this.err_code = err_code;
	}

	
	    
}
