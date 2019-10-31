package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.testing.Logging;

public class Comment extends Asset {

	private String text;
	
	public Comment(String text) {
		this.text = text;
	}

	@Override
	public String buildLine() {
		Logging.LogComment("Creating Comment...");
		String line = "<!-- " + text + " -->";
		return line;
	}
}
