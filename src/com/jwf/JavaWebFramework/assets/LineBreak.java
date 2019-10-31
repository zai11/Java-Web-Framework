package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.testing.Logging;

public class LineBreak extends Asset {

	public LineBreak() {}
	
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Line Break...");
		String line = "<br />";
		return line;
	}

}
