package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.assets.form.Button;
import com.jwf.JavaWebFramework.assets.form.Form;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Link Builder - All attributes are set and then the final link is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/links.html#ButtonBuilder">Documentation</a>
 * @see Button
 * @see Asset
 * @see Form
 */
public class LinkBuilder extends Builder<Link> {

	String text;
	String address;
	
	/**
	 * Adds a CSS class to the link.
	 * @param 	cl	the class to be added
	 * @return	the LinkBuilder object
	 */
	public LinkBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the link.
	 * @param 	id	the id to be set
	 * @return	the LinkBuilder object
	 */
	public LinkBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Sets the text of the link.
	 * @param 	text	the text to be added
	 * @return	the LinkBuilder object
	 */
	public LinkBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Sets the address of the link.
	 * @param 	address	the address to be set
	 * @return	the LinkBuilder object
	 */
	public LinkBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	/**
	 * Builds the link.
	 * @return	the constructed link
	 */
	@Override
	public Asset build() {
		return new Link(text, address, id, classes);
	}
}
