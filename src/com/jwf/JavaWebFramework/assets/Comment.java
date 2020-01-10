package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A HTML comment - equivalent to the HTML {@code <!-- -->} tags.
 * See <a href="../../Documentation/HTML/Assets/General/comments.html">Documentation</a>
 * @see Asset
 */
public class Comment extends Asset {

	private String text;
	
	/**
	 * Constructs a comment using the given parameters.
	 * @param 	text	the text in the comment
	 */
	public Comment(String text) {
		this.assetType = Assets.COMMENT;
		this.text = text;
	}

	/**
	 * Builds the HTML line for the comment based on the set variables.
	 * @return	the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Comment...");
		String line = "<!-- " + text + " -->";
		return line;
	}
}
