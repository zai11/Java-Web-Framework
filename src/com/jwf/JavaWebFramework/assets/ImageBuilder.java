package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class ImageBuilder extends Builder<Image> {

	String src;
	String alt;
	
	public ImageBuilder setSource(String src) {
		this.src = src;
		return this;
	}
	
	public ImageBuilder setAlt(String alt) {
		this.alt = alt;
		return this;
	}
	
	public ImageBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	public ImageBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	@Override
	public Asset build() {
		return new Image(src, alt, id, classes);
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
