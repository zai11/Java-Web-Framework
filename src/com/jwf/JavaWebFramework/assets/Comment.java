package com.jwf.JavaWebFramework.assets;

public class Comment extends Asset {

	private String text;
	
	public Comment(String text) {
		this.text = text;
	}

	@Override
	public String buildLine() {
		System.out.println("Creating Comment...");
		String line = "<!-- " + text + " -->";
		System.out.println("Done!");
		return line;
	}
}
