package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class CommentBuilder extends Builder<Comment> {

	private String text;
	
	public CommentBuilder setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public Asset build() {
		return new Comment(text);
	}

	@Override
	public Class buildClass() {
		return null;
	}

	@Override
	public ID buildID() {
		return null;
	}

}
