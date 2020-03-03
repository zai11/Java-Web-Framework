package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Select Box Builder - All attributes are set and then the final select box is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/select_box.html#SelectBoxBuilder">Documentation</a>
 * 
 * @see Asset
 * @see Form
 * @see SelectBox
 */
public class SelectBoxBuilder extends Builder<SelectBox> {

	int size;
	boolean autofocus;
	boolean disabled;
	boolean multiple;
	boolean required;
	String form;
	String name;
	
	/**
	 * Sets the size of the select box.
	 * @param 	size	the size to be set
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setSize(int size) {
		this.size = size;
		return this;
	}
	
	/**
	 * Sets whether or not the select box should automatically be in focus.
	 * @param 	autofocus	whether the select box should automatically be in focus (true) or not (false)
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setAutofocus(boolean autofocus) {
		this.autofocus = autofocus;
		return this;
	}
	
	/**
	 * Sets whether or not the select box should be disabled.
	 * @param 	disabled	whether the select box should be disabled (true) or not (false)
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	/**
	 * Sets whether or not multiple object can be selected.
	 * @param 	multiple	whether multiple items can be selected (true) or not (false)
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setMultiple(boolean multiple) {
		this.multiple = multiple;
		return this;
	}
	
	/**
	 * Sets whether or not the select box is required.
	 * @param 	required	whether the select box is required (true) or not (false)
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setRequired(boolean required) {
		this.required = required;
		return this;
	}
	
	/**
	 * Sets the parent form of the select box.
	 * @param 	form	the parent form to be set
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setForm(String form) {
		this.form = form;
		return this;
	}
	
	/**
	 * Sets the name of the select box.
	 * @param 	name	the name to be set
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * Adds a CSS class to the select box.
	 * @param 	cl	the class to be added
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	/**
	 * Sets the ID of the select box.
	 * @param 	id	the id to be set
	 * @return	the SelectBoxBuilder object
	 */
	public SelectBoxBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Builds the select box.
	 * 
	 * @return	the constructed select box
	 */
	@Override
	public Asset build() {
		return new SelectBox(size, autofocus, disabled, multiple, required, form, name, id, classes);
	}
}
