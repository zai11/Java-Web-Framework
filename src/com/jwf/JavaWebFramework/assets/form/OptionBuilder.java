package com.jwf.JavaWebFramework.assets.form;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class OptionBuilder extends Builder<Option> {

	String label;
	String value;
	boolean selected = false;
	boolean disabled = false;
	
	public OptionBuilder setLabel(String label) {
		this.label = label;
		return this;
	}
	
	public OptionBuilder setValue(String value) {
		this.value = value;
		return this;
	}
	
	public OptionBuilder setSelected(boolean selected) {
		this.selected = selected;
		return this;
	}
	
	public OptionBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	public OptionBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public OptionBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	@Override
	public Asset build() {
		return new Option(label, value, selected, disabled, id, classes);
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
