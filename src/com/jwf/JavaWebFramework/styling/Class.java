package com.jwf.JavaWebFramework.styling;

import java.util.ArrayList;
import java.util.List;

public class Class {

	private String name;
	private List<Attribute> attributes = new ArrayList<>();
	private List<PseudoClass> pseudoclasses = new ArrayList<>();
	
	public Class(String name, List<Attribute> attributes, List<PseudoClass> pseudoclasses) {
		this.name = name;
		this.attributes = attributes;
		this.pseudoclasses = pseudoclasses;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Attribute> getAttribs() {
		return this.attributes;
	}
	
	public List<PseudoClass> getPseudoclasses() {
		return this.pseudoclasses;
	}
}
