package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A span - equivalent to the HTML {@code <span>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/spans.html">Documentation</a>
 * @see Asset
 */
public class Span extends Asset {

	String content;
	String style;
	
	/**
	 * Constructs a Span using the given parameters.
	 * @param content	the html content inside the span
	 * @param style		the style to be attached to the span
	 * @param id		the CSS id of the span
	 * @param classes	any CSS classes to be attached to the span
	 */
	public Span(String content, String style, ID id, List<Class> classes) {
		this.assetType = Assets.SPAN;
		this.content = content;
		this.style = style;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the span based on the set variables.
	 * @return	the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Span...");
		String line = "<span";
		if (style != null && !style.isEmpty())
			line += " style=\"" + style + "\"";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getValue() + "'";
		line += ">";
		if (content != null && !content.isEmpty())
			line += content;
		line += "</span>";
		return line;
	}
}
