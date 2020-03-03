package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Button Builder - All attributes are set and then the final button is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/buttons.html#ButtonBuilder">Documentation</a>
 * @see Button
 * @see Asset
 * @see Form
 */
public class ButtonBuilder extends Builder<Button> {

	String type;
	String text;
	String name;
	boolean disabled;
	
	/**
	 * Sets the type of button.
	 * @param 	type	the type to be set
	 * @return	the ButtonBuilder object
	 */
	public ButtonBuilder setType(String type) {
		this.type = type;
		return this;
	}
	
	/**
	 * Sets the text in the button.
	 * @param 	text	the text to be set
	 * @return	the ButtonBuilder object
	 */
	public ButtonBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Sets the name of the button.
	 * @param	name	the name to be set
	 * @return	the ButtonBuilder object
	 */
	public ButtonBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Sets whether the button is enabled or disabled.
	 * @param 	disabled	whether the button is disabled (true) or enabled (false)
	 * @return	the ButtonBuilder object
	 */
	public ButtonBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	/**
	 * Adds a CSS Class to the button.
	 * @param 	cl	the class to be added
	 * @return	the ButtonBuilder object
	 */
	public ButtonBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the CSS ID of the button.
	 * @param 	id	the ID to be set
	 * @return	the ButtonBuilder object
	 */
	public ButtonBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Builds the button.
	 * @return 	the constructed button
	 */
	@Override
	public Asset build() {
		return new Button(type, text, name, disabled, id, classes);
	}
}
