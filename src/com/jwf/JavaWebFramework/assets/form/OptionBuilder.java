package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An Option Builder - All attributes are set and then the final option is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/options.html#OptionBuilder">Documentation</a>
 * @see Asset
 * @see Form
 * @see SelectBox
 * @see Option
 */
public class OptionBuilder extends Builder<Option> {

	String label;
	String value;
	boolean selected = false;
	boolean disabled = false;
	
	/**
	 * Sets the label of the option.
	 * @param	label	the label to be set
	 * @return	the OptionBuilder object
	 */
	public OptionBuilder setLabel(String label) {
		this.label = label;
		return this;
	}
	
	/**
	 * Sets the value of the option.
	 * @param 	value	the value to be set
	 * @return	the OptionBuilder object
	 */
	public OptionBuilder setValue(String value) {
		this.value = value;
		return this;
	}
	
	/**
	 * Sets whether or not the option should be selected by default.
	 * @param 	selected	whether the option should be selected (true) or not (false)
	 * @return	the OptionBuilder object
	 */
	public OptionBuilder setSelected(boolean selected) {
		this.selected = selected;
		return this;
	}
	
	/**
	 * Sets whether or not the option should be disabled by default.
	 * @param 	disabled	whether the option should be disabled (true) or not (false)
	 * @return	the OptionBuilder object
	 */
	public OptionBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	/**
	 * Adds a CSS class to the option.
	 * @param 	cl	the class to be added
	 * @return	the OptionBuilder object
	 */
	public OptionBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the option.
	 * @param 	id	the id to be set
	 * @return	the OptionBuilder object
	 */
	public OptionBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	/**
	 * Builds the option.
	 * @return the constructed option
	 */
	@Override
	public Asset build() {
		return new Option(label, value, selected, disabled, id, classes);
	}
}
