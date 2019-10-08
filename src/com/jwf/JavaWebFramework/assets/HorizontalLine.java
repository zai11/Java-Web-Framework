package com.jwf.JavaWebFramework.assets;

public class HorizontalLine extends Asset {

	public HorizontalLine() {}
	
	@Override
	public String buildLine() {
		System.out.println("Creating Horizontal Line...");
		String line = "<hr />";
		System.out.println("Done!");
		return line;
	}

}
