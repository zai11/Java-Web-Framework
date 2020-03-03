package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An Input Builder - All attributes are set and then the final input is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/inputs.html#InputBuilder">Documentation</a>
 * @see Input
 * @see Asset
 * @see Form
 */
public class InputBuilder extends Builder<Input> {
	
	String type;
	String name;
	String text;
	boolean required;
	
	/**
	 * Sets the type of the input.
	 * @param 	type	the type to be set
	 * @return	the InputBuilder object
	 */
	public InputBuilder setType(String type) {
		this.type = type;
		return this;
	}
	
	/**
	 * Sets the name of the input.
	 * @param 	name	the name to be set
	 * @return	the InputBuilder object
	 */
	public InputBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets the default text of the input.
	 * @param 	text	the text to be set
	 * @return	the InputBuilder object
	 */
	public InputBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Sets whether or not the input field is required.
	 * @param 	required	whether it is required (true) or not (false)
	 * @return	the InputBuilder object
	 */
	public InputBuilder setRequired(boolean required) {
		this.required = required;
		return this;
	}
	
	/**
	 * Adds a CSS class to the input.
	 * @param 	cl	the class to be added
	 * @return	the InputBuilder object
	 */
	public InputBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	/**
	 * Sets the id of the input.
	 * @param 	id	the id to be set
	 * @return	the InputBuilder object
	 */
	public InputBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Builds the input.
	 * @return 	the constructed input
	 */
	@Override
	public Asset build() {
		return new Input(type, name, text, required, id, classes);
	}
}
