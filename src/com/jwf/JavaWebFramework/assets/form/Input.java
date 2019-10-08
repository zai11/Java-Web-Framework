package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An input for a form - equivalent to the HTML {@code <input>} tags.
 * See <a href="">Documentation</a>
 * @see Asset
 * @see Form
 */
public class Input extends Asset {

	String type;
	String name;
	String text;
	boolean required;
	
	/**
	 * Constructs an input using the given parameters.
	 * @param type     the type of the input
	 * @param name     the name of the input
	 * @param text     the text that will be displayed
	 * @param required whether it will be required or not
	 * @param id       the CSS ID of the input
	 * @param classes  any CSS classes to be attached
	 */
	public Input(String type, String name, String text, boolean required, ID id, List<Class> classes) {
		this.type = type;
		this.name = name;
		this.text = text;
		this.required = required;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the input based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		System.out.println("Creating Input...");
		String line = "<input";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getName() + "'";
		if (required)
			line += " required='required'";
		if (!name.isEmpty())
			line += " name='" + name + "'";
		line += " type='" + type + "' >" + text + "</button>";
		System.out.println("Done!");
		return line;
	}
}
