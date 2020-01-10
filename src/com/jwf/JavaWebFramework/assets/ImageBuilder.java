package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An Image Builder - All attributes are set and then the final image is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/images.html#ImageBuilder">Documentation</a>
 * @see Image
 * @see Asset
 */
public class ImageBuilder extends Builder<Image> {

	String src;
	String alt;
	
	/**
	 * Sets the source of the image.
	 * @param 	src	the source to be set
	 * @return	the ImageBuilder object
	 */
	public ImageBuilder setSource(String src) {
		this.src = src;
		return this;
	}
	
	/**
	 * Sets the alternate text of the image.
	 * @param 	alt	the alternate text to be set
	 * @return	the ImageBuilder
	 */
	public ImageBuilder setAltText(String alt) {
		this.alt = alt;
		return this;
	}
	
	/**
	 * Adds a CSS class to the image.
	 * @param 	cl	the class to be added
	 * @return	the ImageBuilder object
	 */
	public ImageBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	/**
	 * Sets the ID of the image.
	 * @param 	id	the id to be set
	 * @return	the ImageBuilder object
	 */
	public ImageBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Builds the image.
	 * @return the constructed image
	 */
	@Override
	public Asset build() {
		return new Image(src, alt, id, classes);
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
