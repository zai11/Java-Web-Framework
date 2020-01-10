package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A Paragraph Builder - All attributes are set and then the final paragraph is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/paragraph.html#ParagraphBuilder">Documentation</a>
 * @see Paragraph
 * @see Asset
 * @see Form
 */
public class ParagraphBuilder extends Builder<Paragraph> {

	private String text;
	
	/**
	 * Sets the text of the paragraph.
	 * @param 	text	the text to be set
	 * @return	the ParagraphBuilder object
	 */
	public ParagraphBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Adds a CSS class to the paragraph.
	 * @param 	cl	the class to be added
	 * @return	the ParagraphBuilder object
	 */
	public ParagraphBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the paragraph.
	 * @param 	id	the id to be added
	 * @return	the ParagraphBuilder object
	 */
	public ParagraphBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Clears the id of the paragraph.
	 * @return	the ParagraphBuilder object
	 */
	public ParagraphBuilder clearID() {
		this.id = null;
		return this;
	}
	
	/**
	 * Builds the paragraph.
	 * @return	the constructed paragraph
	 */
	public Paragraph build() {
		return new Paragraph(text, id, classes);
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
