package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Heading Builder - All attributes are set and then the final heading is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/headings.html#HeadingBuilder">Documentation</a>
 * @see Asset
 * @see Heading
 */
public class HeadingBuilder extends Builder<Heading> {

	int size;
	String text;
	
	/**
	 * Adds a CSS class to the heading.
	 * @param 	cl	the class to be added
	 * @return	the HeadingBuilder object
	 */
	public HeadingBuilder addClass(Class cl) {
		this.classes.add(cl);
		return null;
	}

	/**
	 * Sets the ID of the heading.
	 * @param 	id	the id to be set
	 * @return	the HeadingBuilder object
	 */
	public HeadingBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Sets the size of the heading.
	 * @param 	size	the size to be set
	 * @return	the HeadingBuilder object
	 */
	public HeadingBuilder setSize(int size) {
		this.size = size;
		return this;
	}
	
	/**
	 * Sets the text of the heading.
	 * @param 	text	the text to be set
	 * @return	the HeadingBuilder object
	 */
	public HeadingBuilder setText(String text) {
		this.text = text;
		return this;
	}

	/**
	 * Builds the heading.
	 * @return the constructed heading
	 */
	@Override
	public Asset build() {
		return new Heading(text, size, id, classes);
	}
}
