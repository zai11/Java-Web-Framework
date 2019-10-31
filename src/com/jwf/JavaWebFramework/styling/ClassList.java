package com.jwf.JavaWebFramework.styling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jwf.JavaWebFramework.misc.testing.Logging;

/**
 * An iterable list of CSS classes.
 */
public class ClassList implements Iterable<Class> {

	List<Class> classes = new ArrayList<Class>();
	
	/**
	 * Constructs the class list.
	 */
	public ClassList () {}
	
	/**
	 * Adds a class to the class list.
	 * @param newClass the new class
	 */
	public void addClass(Class newClass) { 
		classes.add(newClass);
	}
	
	/**
	 * Gets a class with the given name.
	 * @param name the name to search for
	 * @return the class
	 */
	public Class getClass(String name) {
		for (Class c : classes) {
			if (c.getName().equals(name))
				return c;
		}
		Logging.LogError("Unable to find class name: " + name + ".");
		return null;
	}

	/**
	 * Returns an iterator over elements of type Class
	 */
	@Override
	public Iterator<Class> iterator() {
		return classes.iterator();
	}
}
