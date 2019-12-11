package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Block;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A form for the user to complete - equivalent to the HTML {@code <form>} tags.
 * See <a href="../../../Documentation/HTML/Assets/Forms/forms.html">Documentation</a>
 * @see Asset
 * @see Block
 */
public class Form extends Asset {
	
	List<Asset> children = new ArrayList<>();
	
	/**
	 * Constructs a form using the given parameters.
	 * @param id       the CSS id of the form
	 * @param classes  any CSS classes to be attached
	 * @param children an array of the child assets
	 */
	public Form(ID id, List<Class> classes, List<Asset> children) {
		this.id = id;
		this.classes = classes;
		this.children = children;
	}
	
	/**
	 * Builds the HTML line for the form based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Form...");
		String line = "<form";
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
		for (Asset child : children) {
			line += child.buildLine() + "\n";
		}
		line += "</form>";
		return line;
	}
}
