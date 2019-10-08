package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

public class BlockBuilder extends Builder<Block> {

	private List<Asset> children = new ArrayList<Asset>();
	
	public BlockBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	public BlockBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	public BlockBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	@Override
	public Asset build() {
		return new Block(id, classes, children);
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
