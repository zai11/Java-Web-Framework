package com.jwf.JavaWebFramework.assets.form;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class FieldSetBuilder extends Builder<FieldSet> {

	List<Asset> children = new ArrayList<Asset>();
	
	public FieldSetBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	public FieldSetBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public FieldSetBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	@Override
	public Asset build() {
		return new FieldSet(id, classes, children);
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
