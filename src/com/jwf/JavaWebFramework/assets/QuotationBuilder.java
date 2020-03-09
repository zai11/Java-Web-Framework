package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Quotation Builder - All attributes are set and then the final quotation block is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/quotations.html#QuotationBuilder">Documentation</a>
 * @see Asset
 * @see Quotation
 */
public class QuotationBuilder extends Builder<Quotation> {

	private String text;
	private String source;
	
	/**
	 * Sets the text of the quotation.
	 * @param 	text	the text to be set
	 * @return	the QuotationBuilder object
	 */
	public QuotationBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Sets the source of the quotation.
	 * @param 	source	source to be set
	 * @return	the QuotationBuilder object
	 */
	public QuotationBuilder setSource(String source) {
		this.source = source;
		return this;
	}
	
	/**
	 * Adds a CSS class to the quotation.
	 * @param 	cl	the class to be added
	 * @return	the QuotationBuilder object
	 */
	public QuotationBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the quotation.
	 * @param 	id	the id to be added
	 * @return	the QuotationBuilder object
	 */
	public QuotationBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Clears the id of the quotation.
	 * @return	the QuotationBuilder object
	 */
	public QuotationBuilder clearID() {
		this.id = null;
		return this;
	}
	
	/**
	 * Builds the quotation.
	 * @return	the constructed quotation
	 */
	@Override
	public Quotation build() {
		return new Quotation(text, source, id, classes);
	}

}
