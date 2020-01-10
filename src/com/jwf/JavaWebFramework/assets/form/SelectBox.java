package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A drop-down list - equivalent to the HTML {@code <select>} tags.
 * See <a href=
 * "../../../Documentation/HTML/Assets/Forms/select_boxes.html">Documentation</a>
 * 
 * @see Asset
 * @see Form
 */
public class SelectBox extends Asset {

	int size;
	boolean autofocus;
	boolean disabled;
	boolean multiple;
	boolean required;
	String form;
	String name;
	
	/**
	 * Constructs a Select Box using the given parameters.
	 * 
	 * @param size		the size of the select box
	 * @param autofocus	whether the select box should automatically get focus (true) or not (false)
	 * @param disabled	whether the select box should automatically be disabled (true) or not (false)
	 * @param multiple	whether multiple options can be selected (true) or not (false)
	 * @param required	whether the select box should be required (true) or not (false)
	 * @param form		the parent form of the select box
	 * @param name		the name of the select box
	 * @param id		the id of the select box
	 * @param classes	the CSS classes to be attached
	 */
	public SelectBox (int size, boolean autofocus, boolean disabled, boolean multiple, boolean required, String form, String name, ID id, List<Class> classes) {
		this.assetType = Assets.SELECT_BOX;
		this.size = size;
		this.autofocus = autofocus;
		this.disabled = disabled;
		this.multiple = multiple;
		this.required = required;
		this.form = form;
		this.name = name;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Builds the HTML line for the select box based on the set variables.
	 * 
	 * @return	the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Select Box...");
		String line = "<select";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getValue() + "'";
		if (size != 0)
			line += " size='" + size + "'";
		if (autofocus)
			line += " autofocus";
		if (disabled)
			line += " disabled";
		if (multiple)
			line += " multiple";
		if (required)
			line += " required";
		if (form != null)
			line += " form='" + form + "'";
		if (name != null)
			line += " name='" + name + "'";
		line += ">";
		line += "</select>";
		return line;
	}
}
