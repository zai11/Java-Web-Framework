package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

public class HorizontalLine extends Asset {

	public HorizontalLine() {
		this.assetType = Assets.HORIZONTAL_LINE;
	}
	
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Horizontal Line...");
		String line = "<hr />";
		return line;
	}

}
