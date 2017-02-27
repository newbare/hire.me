package br.com.bemobi.shortener.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Jefferson Leite
 *
 */
@Entity
@Table(name = "TB_SHORTEN")
public class Shorten implements Serializable{

	private static final long serialVersionUID = 1;
 
	@Id
	@GeneratedValue
	@Column(name = "ID_URL")
    public Long idUrl;
    /**
     * Limite de carecter
     * Internet Explorer: 2.083 caracteres 
     * Firefox: 65.536 caracteres
     * Safari: 80.000 caracteres
     * Opera: 190.000 caracteres
     */
    @Column(name = "URL_LONGA")
    public String longUrl;
    
    @Column(name = "URL_CURTA")
    public String shortUrl;
    
    
	@Column(name = "CREATION_DATE")
    public Date creationDate;  
    
    @Column(name = "CLICK")
    public Long click;  
    
    @Transient
    private String description;

	public Long getIdUrl() {
		return idUrl;
	}

	public void setIdUrl(Long idUrl) {
		this.idUrl = idUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getClick() {
		return click;
	}

	public void setClick(Long click) {
		this.click = click;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((click == null) ? 0 : click.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((idUrl == null) ? 0 : idUrl.hashCode());
		result = prime * result + ((longUrl == null) ? 0 : longUrl.hashCode());
		result = prime * result + ((shortUrl == null) ? 0 : shortUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shorten other = (Shorten) obj;
		if (click == null) {
			if (other.click != null)
				return false;
		} else if (!click.equals(other.click))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (idUrl == null) {
			if (other.idUrl != null)
				return false;
		} else if (!idUrl.equals(other.idUrl))
			return false;
		if (longUrl == null) {
			if (other.longUrl != null)
				return false;
		} else if (!longUrl.equals(other.longUrl))
			return false;
		if (shortUrl == null) {
			if (other.shortUrl != null)
				return false;
		} else if (!shortUrl.equals(other.shortUrl))
			return false;
		return true;
	}

	

}
