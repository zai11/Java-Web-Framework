package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An IFrame Builder - All attributes are set and then the final IFrame is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/iframe.html#IFrameBuilder">Documentation</a>
 * @see Asset
 * @see IFrame
 */
public class IFrameBuilder extends Builder<IFrame> {

	String align;
	boolean allowFullscreen;
	boolean allowPaymentRequest;
	boolean frameBorder;
	float height = -1f;
	String longDesc;
	float marginHeight = -1f;
	float marginWidth = -1f;
	String name;
	String referrerPolicy;
	String sandbox;
	String scrolling;
	String src;
	String srcDoc;
	float width = -1f;

	/**
	 * Sets the alignment of the iframe.
	 * @param align	the alignment to be set
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setAlign(String align) {
		this.align = align;
		return this;
	}

	/**
	 * Sets whether the iframe can activate fullscreen mode or not.
	 * @param allowFullscreen	whether the iframe can activate fullscreen mode or not
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setAllowFullscreen(boolean allowFullscreen) {
		this.allowFullscreen = allowFullscreen;
		return this;
	}

	/**
	 * Sets whether the iframe should be able to invoke the Payment Request API or not.
	 * @param allowPaymentRequest	whether the iframe should be able to invoke the Payment Request API or not
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setAllowPaymentRequest(boolean allowPaymentRequest) {
		this.allowPaymentRequest = allowPaymentRequest;
		return this;
	}

	/**
	 * Sets whether to display a border around the iframe or not.
	 * @param frameBorder	whether to display a border around the iframe or not
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setFrameBorder(boolean frameBorder) {
		this.frameBorder = frameBorder;
		return this;
	}

	/**
	 * Sets the height of the iframe.
	 * @param height	the height to be set
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setHeight(float height) {
		this.height = height;
		return this;
	}

	/**
	 * Sets the long description page of the iframe.
	 * @param longDesc	a page that contains a long description of the content of the iframe
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setLongDesc(String longDesc) {
		this.longDesc = longDesc;
		return this;
	}

	/**
	 * Sets the top and bottom margins of the iframe.
	 * @param marginHeight	the top and bottom margins of the iframe
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setMarginHeight(float marginHeight) {
		this.marginHeight = marginHeight;
		return this;
	}

	/**
	 * Sets the left and right margins of the iframe.
	 * @param marginWidth	the left and right margins of the iframe
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setMarginWidth(float marginWidth) {
		this.marginWidth = marginWidth;
		return this;
	}

	/**
	 * Sets the name of the iframe.
	 * @param name	the name to be set
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sets the referrer policy used when processing the iframe attributes.
	 * @param referrerPolicy	the referrer policy used when processing the iframe attributes
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setReferrerPolicy(String referrerPolicy) {
		this.referrerPolicy = referrerPolicy;
		return this;
	}

	/**
	 * Sets an extra set of restrictions for the content in the iframe.
	 * @param sandbox	an extra set of restrictions for the content in the iframe
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setSandbox(String sandbox) {
		this.sandbox = sandbox;
		return this;
	}

	/**
	 * Sets whether or not to display a scrollbar in the iframe.
	 * @param scrolling	whether or not to display a scrollbar in the iframe
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setScrolling(String scrolling) {
		this.scrolling = scrolling;
		return this;
	}

	/**
	 * Sets the source page to be displayed.
	 * @param src	the source page to be displayed
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setSource(String src) {
		this.src = src;
		return this;
	}

	/**
	 * Sets the html content of the page to show in the iframe.
	 * @param srcDoc	the html content of the page to show in the iframe
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setSrcDoc(String srcDoc) {
		this.srcDoc = srcDoc;
		return this;
	}

	/**
	 * Sets the width of the iframe.
	 * @param width	the width to be set
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setWidth(float width) {
		this.width = width;
		return this;
	}
	
	/**
	 * Adds a CSS class to the iframe.
	 * @param 	cl	the class to be added
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the iframe.
	 * @param 	id	the id to be added
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Clears the id of the iframe.
	 * @return	the IFrameBuilder object
	 */
	public IFrameBuilder clearID() {
		this.id = null;
		return this;
	}

	/**
	 * Builds the iframe.
	 * @return	the constructed iframe
	 */
	@Override
	public Asset build() {
		return new IFrame(src, name, align, allowFullscreen, allowPaymentRequest, frameBorder, height, longDesc,
				marginHeight, marginWidth, referrerPolicy, sandbox, scrolling, srcDoc, width, id, classes);
	}
}
