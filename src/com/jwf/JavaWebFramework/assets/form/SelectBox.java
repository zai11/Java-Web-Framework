package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A drop-down list - equivalent to the HTML {@code <select>} tags.
 * See <a href=
 * "../../../Documentation/HTML/Assets/Forms/SelectBox.html">Documentation</a>
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
	
	public SelectBox (int size, boolean autofocus, boolean disabled, boolean multiple, boolean required, String form, String name, ID id, List<Class> classes) {
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
	
	@Override
	public String buildLine() {
		System.out.println("Creating Select Box...");
		String line = "<select";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getName() + "'";
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
		System.out.println("Done!");
		return line;
	}
}
