package com.jwf.JavaWebFramework.styling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jwf.JavaWebFramework.misc.testing.Logging;

/**
 * An iterable list of CSS IDs.
 */
public class IDList implements Iterable<ID> {

	List<ID> ids = new ArrayList<ID>();
	
	/**
	 * Constructs the ID list.
	 */
	public IDList () {}
	
	/**
	 * Adds an ID to the ID list.
	 * @param newID the new ID
	 */
	public void addID(ID newID) { 
		ids.add(newID);
	}
	
	/**
	 * Gets an ID with the given name.
	 * @param name the name to search for
	 * @return the ID
	 */
	public ID getID(String name) {
		for (ID id : ids) {
			if (id.getValue().equals(name))
				return id;
		}
		Logging.LogError("Error: Unable to find id: " + name + ".");
		return null;
	}

	/**
	 * Returns an iterator over elements of type ID
	 */
	@Override
	public Iterator<ID> iterator() {
		return ids.iterator();
	}
}
