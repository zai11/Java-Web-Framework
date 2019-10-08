package com.jwf.JavaWebFramework.styling;

import java.util.ArrayList;
import java.util.List;

public class ID {
	
	public static final ID NULL = new ID("", new ArrayList<Attribute>());
	
	private String name;
	private List<Attribute> attributes = new ArrayList<Attribute>();
	
	public ID(String name, List<Attribute> attributes) {
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
