package com.jwf.JavaWebFramework.js.builder;

/**
 * An abstract representation of a statement. 
 * All statements will inherit from this class.
 */
public abstract class Statement {
	
	public String body = "";
	
	public abstract String build();
}
