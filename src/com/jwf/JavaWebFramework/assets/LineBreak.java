package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

public class LineBreak extends Asset {

	public LineBreak() {
		this.assetType = Assets.LINE_BREAK;
	}
	
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Line Break...");
		String line = "<br />";
		return line;
	}

}
