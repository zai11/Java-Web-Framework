package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class LabelBuilder extends Builder<Label> {

	String text;
	String parent;
	
	public LabelBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	public LabelBuilder setParent(String parent) {
		this.parent = parent;
		return this;
	}
	
	public LabelBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public LabelBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	@Override
	public Asset build() {
		return new Label(text, parent, id, classes);
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
