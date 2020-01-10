package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A label for a form - equivalent to the HTML {@code <label>} tags.
 * See <a href="../../../Documentation/HTML/Assets/Forms/labels.html">Documentation</a>
 * @see Asset
 * @see Form
 */
public class Label extends Asset {

	String text;
	String parent;
	
	/**
	 * Constructs a label using the given parameters.
	 * @param text     the text that should be displayed
	 * @param id       the CSS ID of the label
	 * @param parent   the parent of the label	
	 * @param classes  any CSS classes to be attached
	 */
	public Label(String text, String parent, ID id, List<Class> classes) {
		this.assetType = Assets.LABEL;
		this.text = text;
		this.parent = parent;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the Label based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Label...");
		String line = "<label";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getValue() + "'";
		line += " for='" + parent + "'";
		line += ">" + text + "</label>";
		return line;
	}
}
