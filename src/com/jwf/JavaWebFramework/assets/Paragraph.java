package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A paragraph of text - equivalent to the HTML {@code <p>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/paragraphs.html">Documentation</a>
 * @see Asset
 */
public class Paragraph extends Asset {

	private String text = "";
	
	/**
	 * Constructs a paragraph using the given parameters.
	 * @param text    the text to be displayed
	 * @param id      the CSS ID of the paragraph
	 * @param classes any CSS classes to be attached
	 */
	public Paragraph(String text, ID id, List<Class> classes) {
		this.text = text;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the paragraph based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Paragraph...");
		String line = "<p";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getValue() + "'";
		line += ">" + text + "</p>";
		return line;
	}
}
