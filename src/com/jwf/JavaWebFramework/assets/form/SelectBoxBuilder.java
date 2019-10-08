package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class SelectBoxBuilder extends Builder<SelectBox> {

	int size;
	boolean autofocus;
	boolean disabled;
	boolean multiple;
	boolean required;
	String form;
	String name;
	
	public SelectBoxBuilder setSize(int size) {
		this.size = size;
		return this;
	}
	
	public SelectBoxBuilder setAutofocus(boolean autofocus) {
		this.autofocus = autofocus;
		return this;
	}
	
	public SelectBoxBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	public SelectBoxBuilder setMultiple(boolean multiple) {
		this.multiple = multiple;
		return this;
	}
	
	public SelectBoxBuilder setRequired(boolean required) {
		this.required = required;
		return this;
	}
	
	public SelectBoxBuilder setForm(String form) {
		this.form = form;
		return this;
	}
	
	public SelectBoxBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public SelectBoxBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	public SelectBoxBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	@Override
	public Asset build() {
		return new SelectBox(size, autofocus, disabled, multiple, required, form, name, id, classes);
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
