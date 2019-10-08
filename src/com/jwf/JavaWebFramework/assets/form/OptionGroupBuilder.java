package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class OptionGroupBuilder extends Builder<OptionGroup> {

	private String label;
	private boolean disabled;
	private List<Asset> children;
	
	public OptionGroupBuilder setLabel(String label) {
		this.label = label;
		return this;
	}
	
	public OptionGroupBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	public OptionGroupBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	public OptionGroupBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	public OptionGroupBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	@Override
	public Asset build() {
		return new OptionGroup(label, disabled, id, classes, children);
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
