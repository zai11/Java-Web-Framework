package com.jwf.JavaWebFramework.assets;

public class LineBreak extends Asset {

	public LineBreak() {}
	
	@Override
	public String buildLine() {
		System.out.println("Creating Comment...");
		String line = "<br />";
		System.out.println("Done!");
		return line;
	}

}
