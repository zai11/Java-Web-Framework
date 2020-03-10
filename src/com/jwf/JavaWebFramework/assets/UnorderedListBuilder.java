package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An Unordered List Builder - All attributes are set and then the final unordered list is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/unordered_lists.html#UnorderedListBuilder">Documentation</a>
 * @see Asset
 * @see UnorderedList
 */
public class UnorderedListBuilder extends Builder<UnorderedList>{
	
	List<String> elements = new ArrayList<String>();
	boolean compact;
	String type;
	
	/**
	 * Adds an element to the unordered list.
	 * @param element	the element to add
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder addElement(String element) {
		this.elements.add(element);
		return this;
	}
	
	/**
	 * Removes an element from the unordered list.
	 * @param element	the element to remove
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder removeElement(String element) {
		for (int i = elements.size(); i > 0; i++) {
			if (elements.get(i).equals(element)) {
				elements.remove(i);
			}
		}
		Logging.LogWarning("Unable to find element: " + element);
		return this;
	}
	
	/**
	 * Clears all elements in the unordered list.
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder clearElements() {
		this.elements.clear();
		return this;
	}
	
	/**
	 * Set the value of the compact variable for the unordered list.
	 * @param compact	whether the unordered list should render smaller than normal or not
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder setCompact(boolean compact) {
		this.compact = compact;
		return this;
	}
	
	/**
	 * Sets the value of the type variable for the unordered list.
	 * @param type	the kind of marker to be used
	 * @return	the OrderedListBuilder object
	 */
	public UnorderedListBuilder setType(String type) {
		this.type = type;
		return this;
	}
	
	/**
	 * Adds a CSS class to the unordered list.
	 * @param 	cl	the class to be added
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the unordered list.
	 * @param 	id	the id to be added
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Clears the id of the unordered list.
	 * @return	the UnorderedListBuilder object
	 */
	public UnorderedListBuilder clearID() {
		this.id = null;
		return this;
	}

	/**
	 * Builds the unordered list.
	 * @return	the constructed unordered list
	 */
	@Override
	public Asset build() {
		return new UnorderedList(elements, compact, type, id, classes);
	}
}