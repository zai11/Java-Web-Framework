package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

public class Comment extends Asset {

	private String text;
	
	public Comment(String text) {
		this.assetType = Assets.COMMENT;
		this.text = text;
	}

	@Override
	public String buildLine() {
		Logging.LogComment("Creating Comment...");
		String line = "<!-- " + text + " -->";
		return line;
	}
}
