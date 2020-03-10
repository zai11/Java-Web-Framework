package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An ordered list - equivalent to the HTML {@code <ol>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/ordered_lists.html">Documentation</a>
 * @see Asset
 */
public class OrderedList extends Asset {

	List<String> elements;
	boolean compact;
	boolean reversed;
	int start;
	String type;

	/**
	 * Constructs an ordered list using the given parameters.
	 * @param elements	a list of all of the elements in the ordered list
	 * @param compact	whether the ordered list should render smaller than normal or not
	 * @param reversed	whether the ordered list should be descending or ascending
	 * @param start		the starting value of the ordered list
	 * @param type		the kind of marker to be used
	 * @param id		the CSS id to be attached to the ordered list
	 * @param classes	any CSS classes to be added to the ordered list
	 */
	public OrderedList(List<String> elements, boolean compact, boolean reversed, int start, String type, ID id,
			List<Class> classes) {
		this.assetType = Assets.ORDERED_LIST;
		this.elements = elements;
		this.compact = compact;
		this.reversed = reversed;
		this.start = start;
		this.type = type;
		this.id = id;
		this.classes = classes;
	}

	/**
	 * Builds the HTML line for the ordered list based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Ordered List...");
		String line = "<ol";
		if (compact)
			line += " compact=\"compact\"";
		if (reversed)
			line += " reversed=\"reversed\"";
		if (start != -1)
			line += " start=\"" + start + "\"";
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
		line += "</ol>";
		return line;
	}
}