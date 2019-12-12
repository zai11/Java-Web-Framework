package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.debugging.Logging;

public class HorizontalLine extends Asset {

	public HorizontalLine() {}
	
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Horizontal Line...");
		String line = "<hr />";
		return line;
	}

}
