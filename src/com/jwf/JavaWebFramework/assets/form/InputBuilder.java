package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class InputBuilder extends Builder<Input> {
	
	String type;
	String name;
	String text;
	boolean required;
	
	public InputBuilder setType(String type) {
		this.type = type;
		return this;
	}
	
	public InputBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public InputBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	public InputBuilder setRequired(boolean required) {
		this.required = required;
		return this;
	}
	
	public InputBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	public InputBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	@Override
	public Asset build() {
		return new Input(type, name, text, required, id, classes);
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
