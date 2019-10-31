package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A grouping of fields in a form - equivalent to the HTML {@code <fieldset>} tags.
 * See <a href="">Documentation</a>
 * @see Asset
 * @see Form
 */
public class FieldSet extends Asset {
	
	List<Asset> children = new ArrayList<Asset>();
	
	/**
	 * Constructs a fieldset using the given parameters.
	 * @param id       the CSS ID of the fieldset
	 * @param classes  any CSS classes to be attached
	 * @param children an array of child assets
	 */
	public FieldSet(ID id, List<Class> classes, List<Asset> children) {
		this.id = id;
		this.classes = classes;
		this.children = children;
	}
	
	/**
	 * Builds the HTML line for the fieldset based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Field Set...");
		String line = "<fieldset";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getName() + "'";
		line += ">\n";
		for (Asset child : children) {
			line += child.buildLine() + "\n";
		}
		line += "</fieldset>";
		return line;
	}
}
