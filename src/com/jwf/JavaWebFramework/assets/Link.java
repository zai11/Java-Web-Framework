package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * A link - equivalent to the HTML {@code <a>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/links.html">Documentation</a>
 * @see Asset
 */
public class Link extends Asset {

	private String text;
	private String address;
	
	/**
	 * Constructs a link using the given parameters.
	 * @param text    the text to be displayed
	 * @param address the address of the link
	 * @param id      the CSS ID of the link
	 * @param classes any CSS classes to be attached
	 */
	public Link(String text, String address, ID id, List<Class> classes) {
		this.text = text;
		this.address = address;
		this.id = id;
		this.classes = classes;
	}

	/**
	 * Builds the HTML line for the link based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		System.out.println("Creating Link...");
		String line = "<a";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getName() + "'";
		line += " href='" + address + "'>" + text + "</a>";
		System.out.println("Done!");
		return line;
	}
}
