package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class ParagraphBuilder extends Builder<Paragraph> {

	private String text;
	
	public ParagraphBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	public ParagraphBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public ParagraphBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	public ParagraphBuilder clearID() {
		this.id = null;
		return this;
	}
	
	public Paragraph build() {
		return new Paragraph(text, id, classes);
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
