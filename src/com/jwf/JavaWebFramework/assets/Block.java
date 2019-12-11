package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A block of assets - equivalent to the HTML {@code <div>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/blocks.html">Documentation</a>
 * @see Asset
 */
public class Block extends Asset {

	protected List<Asset> children = new ArrayList<Asset>();
	
	/**
	 * Constructs a block using the given parameters.
	 * @param id       the CSS ID of the block
	 * @param classes  any CSS classes to be attached
	 * @param children an array of child assets
	 */
	public Block(ID id, List<Class> classes, List<Asset> children) {
		this.id = id;
		this.classes = classes;
		this.children = children;
	}
	
	/**
	 * Builds the HTML line for the block based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Block...");
		String line = "<div";
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
		line += "</div>";
		return line;
	}
}