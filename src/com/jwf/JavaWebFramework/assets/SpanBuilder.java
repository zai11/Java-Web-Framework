package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Span Builder - All attributes are set and then the final span is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/spans.html#SpanBuilder">Documentation</a>
 * @see Asset
 * @see Span
 */
public class SpanBuilder extends Builder<Span> {

	String content;
	String style;
	
	/**
	 * Set the HTML content to be put inside the span.
	 * @param content	the content of the span
	 * @return	the SpanBuilder object
	 */
	public SpanBuilder setContent(String content) {
		this.content = content;
		return this;
	}
	
	/**
	 * Set the CSS style to be attached to the span.
	 * @param style	the style to be attached
	 * @return	the SpanBuilder object
	 */
	public SpanBuilder setStyle(String style) {
		this.style = style;
		return this;
	}
	
	/**
	 * Adds a CSS class to the span.
	 * @param 	cl	the class to be added
	 * @return	the SpanBuilder object
	 */
	public SpanBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the span.
	 * @param 	id	the id to be added
	 * @return	the SpanBuilder object
	 */
	public SpanBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Clears the id of the span.
	 * @return	the SpanBuilder object
	 */
	public SpanBuilder clearID() {
		this.id = null;
		return this;
	}
	
	/**
	 * Builds the span.
	 * @return	the constructed span
	 */
	@Override
	public Asset build() {
		return new Span(content, style, id, classes);
	}
}
