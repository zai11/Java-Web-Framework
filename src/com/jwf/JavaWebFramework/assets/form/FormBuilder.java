package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class FormBuilder extends Builder<Form> {

	List<Asset> children = new ArrayList<>();
	
	public FormBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	public FormBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public FormBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	@Override
	public Asset build() {
		return new Form(id, classes, children);
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
