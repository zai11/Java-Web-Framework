package com.jwf.JavaWebFramework.styling;

import com.jwf.JavaWebFramework.misc.collections.PseudoClasses;

/**
 * A CSS pseuodoclass.
 */
public class PseudoClass {

	private PseudoClasses type;
	private String value;
	private String body;
	
	/**
	 * Constructs a pseudoclass using the given parameters.
	 * @param 	type	the type of pseudoclass
	 * @see PseudoClasses
	 */
	public PseudoClass(PseudoClasses type) {
		this.type = type;
	}
	
	/**
	 * Constructs a pseudoclass using the given parameters.
	 * @param 	type	the type of pseudoclass
	 * @param 	value	the value of the pseudoclass.
	 * @see PseudoClasses
	 */
	public PseudoClass(PseudoClasses type, String value) {
		this.type = type;
		this.value = value;
	}
	
	/**
	 * Changes the type of pseudoclass.
	 * @param 	type	the new type
	 */
	public void changeType(PseudoClasses type) {
		this.type = type;
	}
	
	/**
	 * Changes the value of the pseudoclass.
	 * @param 	value	the new value
	 */
	public void changeValue(String value) {
		this.value = value;
	}
	
	/**
	 * Builds the CSS line for the pseudoclass
	 * @return	the line
	 */
	public String build() {
		this.body = ":" + this.type.toString().toLowerCase();
		if (this.value != null && !this.value.isEmpty()) {
			this.body += "(" + this.value + ")";
		}
		return this.body;
	}
}
