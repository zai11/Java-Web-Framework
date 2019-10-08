package com.jwf.JavaWebFramework.styling;

import java.util.ArrayList;
import java.util.List;

public class Class {

	private String name;
	private List<Attribute> attributes = new ArrayList<Attribute>();
	
	public Class(String name, List<Attribute> attributes) {
		this.name = name;
		this.attributes = attributes;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Attribute> getAttribs() {
		return attributes;
	}
	
}
