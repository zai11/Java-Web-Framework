package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class LinkBuilder extends Builder<Link> {

	String text;
	String address;
	
	public LinkBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public LinkBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	public LinkBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	public LinkBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	@Override
	public Asset build() {
		return new Link(text, address, id, classes);
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
