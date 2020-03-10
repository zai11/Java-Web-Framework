package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An unordered list - equivalent to the HTML {@code <ul>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/unordered_lists.html">Documentation</a>
 * @see Asset
 */
public class UnorderedList extends Asset {

	List<String> elements;
	boolean compact;
	String type;

	/**
	 * Constructs an unordered list using the given parameters.
	 * @param elements	a list of all of the elements in the unordered list
	 * @param compact	whether the unordered list should render smaller than normal or not
	 * @param type		the kind of marker to be used
	 * @param id		the CSS id to be attached to the unordered list
	 * @param classes	any CSS classes to be added to the unordered list
	 */
	public UnorderedList(List<String> elements, boolean compact, String type, ID id,
			List<Class> classes) {
		this.assetType = Assets.ORDERED_LIST;
		this.elements = elements;
		this.compact = compact;
		this.type = type;
		this.id = id;
		this.classes = classes;
	}

	/**
	 * Builds the HTML line for the unordered list based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Unordered List...");
		String line = "<ul";
		if (compact)
			line += " compact=\"compact\"";
		if (type != null && !type.isEmpty())
			line += " type=\"" + type + "\"";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getValue() + "'";
		line += ">\n";
		for (String e : elements) {
			line += "<li>" + e + "</li>\n";
		}
		line += "</ul>";
		return line;
	}
}