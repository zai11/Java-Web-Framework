package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A javascript comment.
 */
public class Comment extends Statement {

	private String text;
	
	/**
	 * Constructs a comment using the provided parameter.
	 * @param	text	the text of the comment
	 */
	public Comment(String text) {
		this.text = text;
	}

	/**
	 * Builds the body of the comment.
	 * @return	the body of the comment.
	 */
	@Override
	public String build() {
		this.body = "//" + text;
		return this.body;
	}
}
