package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class HeadingBuilder extends Builder<Heading> {

	int size;
	String text;
	
	public HeadingBuilder addClass(Class cl) {
		this.classes.add(cl);
		return null;
	}

	public HeadingBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	public HeadingBuilder setSize(int size) {
		this.size = size;
		return this;
	}
	
	public HeadingBuilder setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public Asset build() {
		return new Heading(text, size, id, classes);
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
