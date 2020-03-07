package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.collections.Formatting;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A paragraph of text - equivalent to the HTML {@code <p>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/paragraphs.html">Documentation</a>
 * @see Asset
 */
public class Paragraph extends Asset {

	private String text = "";
	private Formatting format;
	
	/**
	 * Constructs a paragraph using the given parameters.
	 * @param text    the text to be displayed
	 * @param id      the CSS ID of the paragraph
	 * @param classes any CSS classes to be attached
	 */
	public Paragraph(String text, Formatting format, ID id, List<Class> classes) {
		this.assetType = Assets.PARAGRAPH;
		this.text = text;
		this.format = format;
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
		String tag = "";
		switch(format.toString().toLowerCase()) {
		case "none":
			tag = "p";
			break;
		case "bold":
			tag = "b";
			break;
		case "important":
			tag = "strong";
			break;
		case "italic":
			tag = "i";
			break;
		case "emphasized":
			tag = "em";
			break;
		case "marked":
			tag = "mark";
			break;
		case "small":
			tag = "small";
			break;
		case "deleted":
			tag = "del";
			break;
		case "inserted":
			tag = "ins";
			break;
		case "subscript":
			tag = "sub";
			break;
		case "superscript":
			tag = "sup";
			break;
		case "quotation":
			tag = "q";
			break;
		default:
			Logging.LogError("Invalid format: " + format);
			break;
		}
		String line = "<" + tag;
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getValue() + "'";
		line += ">" + text + "</" + tag + ">";
		return line;
	}
}
