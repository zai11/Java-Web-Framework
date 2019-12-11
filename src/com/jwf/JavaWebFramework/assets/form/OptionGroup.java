package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * Used to group related Options in a drop-down list - equivalent to the HTML {@code <optgroup>} tags.
 * See <a href=
 * "../../../Documentation/HTML/Assets/Forms/OptionGroup.html">Documentation</a>
 * 
 * @see Asset
 * @see Form
 * @see SelectBox
 * @see Option
 */
public class OptionGroup extends Asset {
	
	private String label;
	private boolean disabled;
	private List<Asset> children;
	
	public OptionGroup(String label, boolean disabled, ID id, List<Class> classes, List<Asset> children) {
		this.label = label;
		this.disabled = disabled;
		this.id = id;
		this.classes = classes;
		this.children = children;
	}

	@Override
	public String buildLine() {
		Logging.LogComment("Creating Option Group...");
		String line = "<optgroup";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getValue() + "'";
		if (label != null)
			line += " label='" + label + "'";
		if (disabled)
			line += " disabled";
		line += ">\n";
		for (Asset child : children) {
			line += child.buildLine() + "\n";
		}
		line += "</optgroup>";
		return line;
	}
}
