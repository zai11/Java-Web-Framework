package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A FieldSet Builder - All attributes are set and then the final fieldset is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/buttons.html#FieldSetBuilder">Documentation</a>
 * @see FieldSet
 * @see Asset
 * @see Form
 */
public class FieldSetBuilder extends Builder<FieldSet> {

	List<Asset> children = new ArrayList<Asset>();
	
	/**
	 * Adds a field to the fieldset.
	 * @param 	child	the child field to be added
	 * @return	the FieldSetBuilder object
	 */
	public FieldSetBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	/**
	 * Adds a CSS Class to the fieldset.
	 * @param 	cl	the class to be added
	 * @return	the FieldSetBuilder object
	 */
	public FieldSetBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the CSS ID of the fieldset.
	 * @param 	id	the id to be added
	 * @return	the FieldSetBuilder object
	 */
	public FieldSetBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	/**
	 * Builds the fieldset.
	 * @return 	the constructed fieldset
	 */
	@Override
	public Asset build() {
		return new FieldSet(id, classes, children);
	}

	/**
	 * To be removed
	 */
	@Override
	public Class buildClass() {
		return null;
	}

	/**
	 * To be removed
	 */
	@Override
	public ID buildID() {
		return null;
	}

}
