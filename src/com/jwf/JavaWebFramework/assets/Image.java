package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An image - equivalent to the HTML {@code <img>} tag.
 * See <a href="../../Documentation/HTML/Assets/General/images.html">Documentation</a>
 * @see Asset
 */
public class Image extends Asset {

	private static final String IMAGES_PATH = "./res/images/";
	
	private String src;
	private String alt;
	
	/**
	 * Constructs an image using the given parameters.
	 * @param src the source of the image
	 * @param alt the alternative text to be displayed
	 */
	public Image(String src, String alt, ID id, List<Class> classes) {
		this.src = src;
		this.alt = alt;
		this.id = id;
		this.classes = classes;
	}

	/**
	 * Builds the HTML line for the image based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		System.out.println("Creating Image...");
		String line = "<img";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getName() + "'";
		line += " src='" + IMAGES_PATH + src + "' alt='" + alt + "' />";
		System.out.println("Done!");
		return line;
	}
}
