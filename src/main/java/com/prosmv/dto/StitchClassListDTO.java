package com.prosmv.dto;

import java.io.Serializable;
import java.util.List;

import com.prosmv.domain.StitchClass;

public class StitchClassListDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7927097616654098788L;
	private List<StitchClass> stitchClassList;
	
	public StitchClassListDTO(List<StitchClass> stitchClassList) {
		this.stitchClassList = stitchClassList;
	}

	public List<StitchClass> getStitchClassList() {
		return stitchClassList;
	}

	public void setStitchClassList(List<StitchClass> stitchClassList) {
		this.stitchClassList = stitchClassList;
	}
	

}
