package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A heading element - equivalent to the HTML {@code <h1>}-{@code <h6>} elements.
 * See <a href="../../Documentation/HTML/Assets/General/headings.html">Documentation</a>
 * @see Asset
 */
public class Heading extends Asset {

	public static final int BIG = 1;
	public static final int MEDIUM = 2;
	public static final int SMALL = 4;
	public static final int TINY = 6;
	
	private String text;
	private int size;
	
	/**
	 * Constructs a heading using the given parameters.
	 * @param text    the text that will be displayed
	 * @param size    the size of the heading
	 * @param id      the CSS ID of the heading
	 * @param classes any CSS classes to be attached
	 */
	public Heading(String text, int size, ID id, List<Class> classes) {
		if (!checkSize(size)) {
			Logging.LogError("Invalid heading size.");
			return;
		}
		this.text = text;
		this.size = size;
		this.id = id;
		this.classes = classes;
	}
	
	/**
	 * Check whether the size is valid. i.e. between 1 and 6.
	 * @param size the size to be checked
	 * @return whether the size is valid or not
	 */
	private final boolean checkSize(int size) {
		return (size >= 1 && size <= 6);
	}

	/**
	 * Builds the HTML line for the heading based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Heading...");
		String line = "<h" + size;
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='"+ id.getValue() + "'";
		line += ">"+ text +"</h"+ size +">";
		return line;	
	}
}
