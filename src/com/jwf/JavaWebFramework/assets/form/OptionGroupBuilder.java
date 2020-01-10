package com.jwf.JavaWebFramework.assets.form;

import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An Option Group Builder - All attributes are set and then the final option is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/option_groups.html#OptionGroupBuilder">Documentation</a>
 * @see Asset
 * @see Form
 * @see SelectBox
 * @see Option
 * @see OptionGroup
 */
public class OptionGroupBuilder extends Builder<OptionGroup> {

	private String label;
	private boolean disabled;
	private List<Asset> children;
	
	/**
	 * Sets the label of the option group.
	 * @param 	label 	the label to be set
	 * @return	the OptionGroupBuilder object
	 */
	public OptionGroupBuilder setLabel(String label) {
		this.label = label;
		return this;
	}
	
	/**
	 * Sets whether or not the option group should be disabled.
	 * @param 	disabled	whether the option group should be disabled (true) or not (false)
	 * @return	the OptionGroupBuilder object
	 */
	public OptionGroupBuilder setDisabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}
	
	/**
	 * Adds a child option to the option group.
	 * @param 	child	the option to be added
	 * @return	the OptionGroupBuilder object
	 */
	public OptionGroupBuilder addChild(Asset child) {
		this.children.add(child);
		return this;
	}
	
	/**
	 * Adds a CSS class to the option group.
	 * @param 	cl	the class to be added
	 * @return	the OptionGroupBuilder object
	 */
	public OptionGroupBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}
	
	/**
	 * Sets the ID of the option group.
	 * @param 	id	the id to be set
	 * @return	the OptionGroupBuilder object
	 */
	public OptionGroupBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Builds the Option Group.
	 * @return	the constructed option group
	 */
	@Override
	public Asset build() {
		return new OptionGroup(label, disabled, id, classes, children);
	}

	/**
	 * To be removed.
	 */
	@Override
	public Class buildClass() {
		return null;
	}

	/**
	 * To be removed.
	 */
	@Override
	public ID buildID() {
		return null;
	}
	
}
