package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A horizontal line element - equivalent to the HTML {@code <hr />} elements.
 * See <a href="../../Documentation/HTML/Assets/General/horizontal_line.html">Documentation</a>
 * @see Asset
 */
public class HorizontalLine extends Asset {

	/**
	 * Constructs a horizontal line.
	 */
	public HorizontalLine() {
		this.assetType = Assets.HORIZONTAL_LINE;
	}
	
	/**
	 * Builds the HTML line for the horizontal line.
	 * @return	the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Horizontal Line...");
		String line = "<hr />";
		return line;
	}
}