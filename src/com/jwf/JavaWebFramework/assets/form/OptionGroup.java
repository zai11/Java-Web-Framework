package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * Used to group related Options in a drop-down list - equivalent to the HTML {@code <optgroup>} tags.
 * See <a href=
 * "../../../Documentation/HTML/Assets/Forms/option_groups.html">Documentation</a>
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
	
	/**
	 * Constructs an option group using the given parameters.
	 * 
	 * @param label		the label of the option group
	 * @param disabled	whether or not the option group should be disabled
	 * @param id		the id of the option group
	 * @param classes	the CSS classes to be attached
	 * @param children	Any children to be added
	 */
	public OptionGroup(String label, boolean disabled, ID id, List<Class> classes, List<Asset> children) {
		this.assetType = Assets.OPTION_GROUP;
		this.label = label;
		this.disabled = disabled;
		this.id = id;
		this.classes = classes;
		this.children = children;
	}

	/**
	 * Builds the HTML line for the option group based on the set variables.
	 * 
	 * @return	the HTML line
	 */
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
