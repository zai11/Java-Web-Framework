package com.jwf.JavaWebFramework.styling;

//	TODO: Add in functionality for Pseudo-classes.

/**
 * An object representation of a stylesheet.
 * See <a href="">Documentation</a>
 */
public class Stylesheet {

	public ClassList classes = new ClassList();
	public IDList ids = new IDList();	
	private String name;
	
	/**
	 * Constructs a stylesheet using the provided parameters.
	 * @param name the name of the stylesheet
	 */
	public Stylesheet(String name) {
		this.name = name;
	}
	
	/**
	 * Adds a class with the given name to the stylesheet.
	 * @param name the name of the class
	 * @return the class object to be used later
	 */
	public ClassBuilder addClass(String name) {
		ClassBuilder c = new ClassBuilder(name);
		classes.addClass(c.buildClass());
		return c;
	}
	
	/**
	 * Adds a id with the given name to the stylesheet.
	 * @param name the name of the id
	 * @return the id object to be used later
	 */
	public IDBuilder addID(String name) {
		IDBuilder c = new IDBuilder(name);
		ids.addID(c.buildID());
		return c;
	}
	
	/**
	 * Gets the name of the stylesheet.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the stylesheet to the given parameter.
	 * @param newName the new name of the stylesheet
	 */
	public void setName(String newName) {
		name = newName;
	}
}
