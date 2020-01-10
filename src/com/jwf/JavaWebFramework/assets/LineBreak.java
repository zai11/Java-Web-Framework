package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A line break element - equivalent to the HTML {@code <br />} elements.
 * See <a href="../../Documentation/HTML/Assets/General/line_breaks.html">Documentation</a>
 * @see Asset
 */ 
public class LineBreak extends Asset {

	/**
	 * Constructs a line break.
	 */
	public LineBreak() {
		this.assetType = Assets.LINE_BREAK;
	}
	
	/**
	 * Builds the HTML line for the line break.
	 * @return	the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Line Break...");
		String line = "<br />";
		return line;
	}

}
