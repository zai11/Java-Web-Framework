package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A FieldSet Builder - All attributes are set and then the final fieldset is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/buttons.html#FieldSetBuilder">Documentation</a>
 * @see Asset
 * @see Form
 * @see FieldSet
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
}
