package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
/**
 * A quotation - equivalent to the HTML {@code <blockquote>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/paragraphs.html">Documentation</a>
 * @see Asset
 */
public class Quotation extends Asset {

	String text;
	String source;
	
	/**
	 * Constructs a quotation using the given parameters.
	 * @param text    the text to be displayed
	 * @param source	  the source of the quotation
	 * @param id      the CSS ID of the paragraph
	 * @param classes any CSS classes to be attached
	 */
	public Quotation(String text, String source, ID id, List<Class> classes) {
		this.assetType = Assets.QUOTATION;
		this.text = text;
		this.source = source;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the quotation based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Quotation...");
		String line = "<blockquote";
		if (!source.isEmpty())
			line += " cite=\"" + source + "\"";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getValue() + "'";
		line += ">" + text + "</blockquote>";
		return line;
	}
}
