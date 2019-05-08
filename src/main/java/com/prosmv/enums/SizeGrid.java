package com.prosmv.enums;

public enum SizeGrid {
S("small","0-20"),M("medium","20-30");
	private final String key;
    private final String value;
    
    SizeGrid(String key, String value){
    	this.key = key;
    	this.value = value;
    }
    
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
    
    
}
