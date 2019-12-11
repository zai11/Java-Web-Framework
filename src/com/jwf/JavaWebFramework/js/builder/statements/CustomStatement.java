package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class CustomStatement extends Statement {
	
	public CustomStatement(String body) {
		this.body = body;
	}

	@Override
	public String build() {
		return this.body;
	}
}
