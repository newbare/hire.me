package br.com.bemobi.shortener.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author Jefferson Leite
 *
 */
@Entity
@Table(name = "TB_STATISTICS")
public class Statistics implements Serializable {

	private static final long serialVersionUID = -8177374624446064675L;

	@Id
	@GeneratedValue
	@Column(name = "ID")	
	@JsonIgnore
    private Long id;
	
	@Column(name = "TIME_TAKEN")
	private String time_Taken;

	public Statistics() {
		// TODO Auto-generated constructor stub
	}
	
	public Statistics(String time_Taken) {
		super();
		this.time_Taken = time_Taken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime_Taken() {
		return time_Taken;
	}

	public void setTime_Taken(String time_Taken) {
		this.time_Taken = time_Taken;
	}

	
	
}
