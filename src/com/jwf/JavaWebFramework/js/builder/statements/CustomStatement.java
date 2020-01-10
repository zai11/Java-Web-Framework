package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A custom javascript statement.
 * i.e. any statement not supported by JWF
 */
public class CustomStatement extends Statement {
	
	/**
	 * Constructs a custom statement using the provided parameter
	 * @param 	body	the body of the statement
	 */
	public CustomStatement(String body) {
		this.body = body;
	}

	/**
	 * Builds the body of the custom statement.
	 * @return	the body of the custom statement
	 */
	@Override
	public String build() {
		return this.body;
	}
}
