package com.jwf.JavaWebFramework.styling;

import com.jwf.JavaWebFramework.misc.debugging.Logging;

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
	public Class addClass(String name) {
		Class c = new Class(name);
		Logging.LogComment("Added class " + name);
		classes.addClass(c);
		return c;
	}
	
	/**
	 * Adds a id with the given name to the stylesheet.
	 * @param name the name of the id
	 * @return the id object to be used later
	 */
	public ID addID(String name) {
		ID id = new ID(name);
		ids.addID(id);
		return id;
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
