package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.AssetType;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A button for a form - equivalent to the HTML {@code <button>} tags.
 * See <a href="../../../Documentation/HTML/Assets/Forms/buttons.html">Documentation</a>
 * @see Asset
 * @see Form
 */
public class Button extends Asset {
	
	AssetType assetType = AssetType.BUTTON;
	String type;
	String text;
	String name;
	boolean disabled = false;
	
	/**
	 * Constructs a button using the given parameters.
	 * @param type     the type of the button
	 * @param text     the text that should be displayed
	 * @param name     the name of the button
	 * @param disabled whether the button should be disabled
	 * @param id       the CSS ID of the button
	 * @param classes  any CSS classes to be attached
	 */
	public Button(String type, String text, String name, boolean disabled, ID id, List<Class> classes) {
		this.type = type;
		this.text = text;
		this.name = name;
		this.disabled = disabled;
		this.id = id;
		this.classes = classes;
	}

	/**
	 * Builds the HTML line for the button based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Button...");
		String line = "<button";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getName() + "'";
		if (disabled)
			line += " disabled='disabled'";
		line += " type='" + type + "' >" + text + "</button>";
		return line;
	}
}
