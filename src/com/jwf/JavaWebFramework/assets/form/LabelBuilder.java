package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Label Builder - All attributes are set and then the final label is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/labels.html#LabelBuilder">Documentation</a>
 * @see Asset
 * @see Form
 * @see Label
 */
public class LabelBuilder extends Builder<Label> {

	String text;
	String parent;
	
	/**
	 * Sets the text of the label.
	 * @param 	text	the text to be set
	 * @return	the LabelBuilder object
	 */
	public LabelBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Sets the parent form of the label.
	 * @param 	parent	the parent to be set
	 * @return	the LabelBuilder object
	 */
	public LabelBuilder setParent(String parent) {
		this.parent = parent;
		return this;
	}
	
	/**
	 * Adds a CSS class to the label.
	 * @param 	cl	the class to be added
	 * @return	the LabelBuilder object
	 */
	public LabelBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the label.
	 * @param 	id	the id to be set
	 * @return	the LabelBuilder object
	 */
	public LabelBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	/**
	 * Builds the label.
	 * @return	the constructed label
	 */
	@Override
	public Asset build() {
		return new Label(text, parent, id, classes);
	}
}
