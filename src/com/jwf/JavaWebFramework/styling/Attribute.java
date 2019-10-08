package com.jwf.JavaWebFramework.styling;

/**
 * A CSS attribute ("color : #FFF;").
 * <br />
 * See <a href="">Documentation</a>
 */
public class Attribute {

	private String key;
	private String value;
	
	/**
	 * Constructs an attribute based on the given parameters.
	 * @param key   the first part of the attribute
	 * @param value the second part of the attribute
	 */
	public Attribute(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Gets the key of the attribute.
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Gets the value of the attribute
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the key of the attribute to the given parameter.
	 * @param newKey the new key
	 */
	public void setKey(String newKey) {
		key = newKey;
	}

	/**
	 * Sets the value of the attribute to the given parameter.
	 * @param newValue the new value
	 */
	public void setValue(String newValue) {
		value = newValue;
	}
}
