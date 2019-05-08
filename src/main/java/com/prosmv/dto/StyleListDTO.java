package com.prosmv.dto;

import java.io.Serializable;
import java.util.List;

public class StyleListDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7693411857215868213L;

	private List<StyleDTO> styleList;

	public StyleListDTO(List<StyleDTO> styleList) {
       this.styleList = styleList;
	}

	public List<StyleDTO> getStyleListDTOs() {
		return styleList;
	}

	public void setStyleListDTOs(List<StyleDTO> styleList) {
		this.styleList = styleList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
