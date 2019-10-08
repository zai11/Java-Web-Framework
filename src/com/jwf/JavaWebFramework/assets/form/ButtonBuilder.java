package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class ButtonBuilder extends Builder<Button> {

	String type;
	String text;
	String name;
	boolean disabled;
	
	public ButtonBuilder addType(String type) {
		this.type = type;
		return this;
	}
	
	public ButtonBuilder addText(String text) {
		this.text = text;
		return this;
	}
	
	public ButtonBuilder addName(String name) {
		this.name = name;
		return this;
	}
	
	public ButtonBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	public ButtonBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public ButtonBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	@Override
	public Asset build() {
		return new Button(type, text, name, disabled, id, classes);
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
