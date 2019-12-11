package com.jwf.JavaWebFramework.styling;

import java.util.ArrayList;
import java.util.List;

public class ID {
	
	public static final ID NULL = new ID("", new ArrayList<Attribute>());
	
	private String value;
	private List<Attribute> attributes = new ArrayList<Attribute>();
	
	public ID(String value, List<Attribute> attributes) {
		this.value = value;
		this.attributes = attributes;
	}
	
	public String getValue() {
		return value;
	}
	
	public List<Attribute> getAttribs() {
		return attributes;
	}
}
