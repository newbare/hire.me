package br.com.bemobi.shortener.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name = "ID")
	@JsonIgnore
    private Long id;
    
	@JsonIgnore
    @Column(name = "URL_LONGA")
    private String defaultUrl;
    
	
    
	//@JsonIgnore
    @Column(name = "CLICK")
    private Long click;  
	
	@Transient
	private String alias;
	
	@Transient
	private String url;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="SHORTEN_HAS_STATITICS", joinColumns={@JoinColumn(name="SHORTEN_ID", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="STATISTICS_ID", referencedColumnName="id")})
    private List<Statistics> statistics;

    
    public Shorten() {
		// TODO Auto-generated constructor stub
	}
    
	public Shorten(String defaultUrl, List<Statistics> statistics) {
		super();
		this.defaultUrl = defaultUrl;
		this.statistics = statistics;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
	
	public Long getClick() {
		return click;
	}

	public void setClick(Long click) {
		this.click = click;
	}

	public List<Statistics> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<Statistics> statistics) {
		this.statistics = statistics;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}    
	
	

}
