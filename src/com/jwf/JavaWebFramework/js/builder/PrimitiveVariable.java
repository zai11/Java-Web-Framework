package com.jwf.JavaWebFramework.js.builder;

public class PrimitiveVariable<E> {

	private String name = "";
	private Object value;
	
	public PrimitiveVariable(String name, E value) {
		this.name = name;
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
