package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Block Builder - All attributes are set and then the final block is constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/blocks.html#BlockBuilder">Documentation</a>
 * @see Block
 * @see Asset	
 */
public class BlockBuilder extends Builder<Block> {

	private List<Asset> children = new ArrayList<Asset>();
	
	/**
	 * Adds a child to the block.
	 * @param 	child	the child to be added
	 * @return	the BlockBuilder object
	 */
	public BlockBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	/**
	 * Adds a CSS class to the block.
	 * @param 	cl	the class to be added
	 * @return	the BlockBuilder object
	 */
	public BlockBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the block.
	 * @param 	id	the id to be set
	 * @return	the BlockBuilder object
	 */
	public BlockBuilder setID(ID id) {
		this.id = id;
		return this;
	}

	/**
	 * Builds the block.
	 * @return	the constructed block
	 */
	@Override
	public Asset build() {
		return new Block(id, classes, children);
	}
}
