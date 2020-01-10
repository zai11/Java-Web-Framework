package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A Form Builder - All attributes are set and then the final form is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/forms.html#FormBuilder">Documentation</a>
 * @see Form
 * @see Asset
 * @see Form
 */
public class FormBuilder extends Builder<Form> {

	List<Asset> children = new ArrayList<>();
	
	/**
	 * Adds a child asset to the form.
	 * @param 	child	the child asset
	 * @return	The FormBuilder object
	 */
	public FormBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	/**
	 * Adds a CSS class to the form.
	 * @param 	cl	The class to be added
	 * @return	the FormBuilder object
	 */
	public FormBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the element.
	 * @param 	id	The id to be added
	 * @return	the FormBuilder object
	 */
	public FormBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	/**
	 * Builds the form.
	 * @return 	the constructed form
	 */
	@Override
	public Asset build() {
		return new Form(id, classes, children);
	}

	/**
	 * To be removed.
	 */
	@Override
	public Class buildClass() {
		return null;
	}

	/**
	 * To be removed.
	 */
	@Override
	public ID buildID() {
		return null;
	}

}
