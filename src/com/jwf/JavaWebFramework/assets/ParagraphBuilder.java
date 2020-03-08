package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Formatting;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Paragraph Builder - All attributes are set and then the final paragraph is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/paragraph.html#ParagraphBuilder">Documentation</a>
 * @see Asset
 * @see Paragraph
 */
public class ParagraphBuilder extends Builder<Paragraph> {

	private String text;
	private Formatting format = Formatting.NONE;
	
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
	 * Set the type of formatting for the paragraph.
	 * @param format	the type of formatting
	 * @return	the ParagraphBuilder object
	 */
	public ParagraphBuilder setFormatting(Formatting format) {
		this.format = format;
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
		return new Paragraph(text, format, id, classes);
	}
}
