package com.prosmv.dto;

import java.io.Serializable;

import com.prosmv.domain.Range;

public class RangeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8232704685068050256L;
	private Long id;
	private String name;
	
	public RangeDTO(Range range) {
		if(range != null) {
			this.id = range.getId();
			this.name = range.getName();
		}
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param id
	 * @param name
	 */
	public RangeDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
