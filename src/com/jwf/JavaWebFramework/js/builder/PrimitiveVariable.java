package com.jwf.JavaWebFramework.js.builder;

public class PrimitiveVariable<E> {

	String name = "";
	E value;
	
	public PrimitiveVariable(String name, E value) {
		this.value = value;
	}
	
	public E getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
