package com.jwf.JavaWebFramework.js.builder;

/**
 * A primitive variable.
 * e.g. int, String, boolean, etc.
 * @param	<E>	the type of variable
 */
public class PrimitiveVariable<E> {

	private String name = "";
	private Object value;
	
	/**
	 * Constructs a primitive variable using the provided parameters
	 * @param 	name	the name of the variable
	 * @param	value	the value of the variable
	 */
	public PrimitiveVariable(String name, E value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of the primitive variable
	 * @return	the value
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * Gets the name of the primitive variable
	 * @return	the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of the primitive variable
	 * @param 	value	the value
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/**
	 * Sets the name of the primitive variable
	 * @param 	name	the name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
