package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An Ordered List Builder - All attributes are set and then the final ordered list is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/ordered_lists.html#OrderedListBuilder">Documentation</a>
 * @see Asset
 * @see OrderedList
 */
public class OrderedListBuilder extends Builder<OrderedList>{
	
	List<String> elements = new ArrayList<String>();
	boolean compact;
	boolean reversed;
	int start;
	String type;
	
	/**
	 * Adds an element to the ordered list.
	 * @param element	the element to add
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder addElement(String element) {
		this.elements.add(element);
		return this;
	}
	
	/**
	 * Removes an element from the ordered list.
	 * @param element	the element to remove
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder removeElement(String element) {
		for (int i = elements.size(); i > 0; i++) {
			if (elements.get(i).equals(element)) {
				elements.remove(i);
			}
		}
		Logging.LogWarning("Unable to find element: " + element);
		return this;
	}
	
	/**
	 * Clears all elements in the ordered list.
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder clearElements() {
		this.elements.clear();
		return this;
	}
	
	/**
	 * Set the value of the compact variable.
	 * @param compact	whether the ordered list should render smaller than normal or not
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder setCompact(boolean compact) {
		this.compact = compact;
		return this;
	}
	
	/**
	 * Sets the reversed variable for the ordered list.
	 * @param reversed	whether the ordered list should be descending or ascending
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder setReversed(boolean reversed) {
		this.reversed = reversed;
		return this;
	}
	
	/**
	 * Sets the value of the start variable for the ordered list.
	 * @param start	the starting value of the ordered list
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder setStart(int start) {
		this.start = start;
		return this;
	}
	
	/**
	 * Sets the value of the type variable for the ordered list.
	 * @param type	the kind of marker to be used
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder setType(String type) {
		this.type = type;
		return this;
	}
	
	/**
	 * Adds a CSS class to the ordered list.
	 * @param 	cl	the class to be added
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder addClass(Class cl) {
		this.classes.add(cl);
		return this;
	}

	/**
	 * Sets the ID of the ordered list.
	 * @param 	id	the id to be added
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder setID(ID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Clears the id of the ordered list.
	 * @return	the OrderedListBuilder object
	 */
	public OrderedListBuilder clearID() {
		this.id = null;
		return this;
	}

	/**
	 * Builds the ordered list.
	 * @return	the constructed ordered list
	 */
	@Override
	public Asset build() {
		return new OrderedList(elements, compact, reversed, start, type, id, classes);
	}
}