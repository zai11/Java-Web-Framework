package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class Comment extends Statement {

	private String text;
	
	public Comment(String text) {
		this.text = text;
	}

	@Override
	public String build() {
		this.body = "//" + text;
		return this.body;
	}
}
