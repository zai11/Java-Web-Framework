package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An Option for a Select Box - equivalent to the HTML {@code <option>} tags.
 * See <a href=
 * "../../../Documentation/HTML/Assets/Forms/Option.html">Documentation</a>
 * 
 * @see Asset
 * @see Form
 * @see SelectBox
 */

public class Option extends Asset {

	String label;
	String value;
	boolean selected = false;
	boolean disabled = false;

	/**
	 * Constructs an option using the given parameters.
	 * 
	 * @param label    the label of the option
	 * @param value    the value that should be displayed
	 * @param selected whether the option should be selected
	 * @param disabled whether the option should be disabled
	 * @param id       the CSS ID of the option
	 * @param classes  any CSS classes to be attached
	 */
	public Option(String label, String value, boolean selected, boolean disabled, ID id, List<Class> classes) {
		this.label = label;
		this.value = value;
		this.selected = selected;
		this.disabled = disabled;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the button based on the set variables.
	 * 
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Option...");
		String line = "<option";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getName() + "'";
		if (label != null)
			line += " label='" + label + "'";
		if (selected)
			line += " selected";
		if (disabled)
			line += " disabled";
		line += ">" + value + "</option>";
		return line;
	}
}
