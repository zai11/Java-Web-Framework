package com.jwf.JavaWebFramework.styling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import com.jwf.JavaWebFramework.main.SiteConfig;
import com.jwf.JavaWebFramework.main.Website;

/**
 * Builds the stylesheets.
 */
public class StyleBuilder {

	private Website website;
	private final String OUTPUT_PATH = Paths.get(".").toAbsolutePath().normalize().toString() + "/Output Files/";

	/**
	 * Constructs the stylebuilder object using the given parameters.
	 * 
	 * @param website the website to build
	 */
	public StyleBuilder(Website website) {
		this.website = website;
	}

	/**
	 * Builds the stylesheets
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void build() {
		for (Stylesheet style : website.stylesheets) {
			File file = new File(OUTPUT_PATH + '/' + SiteConfig.NAME + "/res/css/" + style.getName() + ".css");
			file.getParentFile().mkdirs();
			try {
				PrintWriter writer = new PrintWriter(file, "UTF-8");
				writeIds(writer, style);
				writeClasses(writer, style);
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Write the IDs.
	 * 
	 * @param writer the PrintWriter object
	 * @param style  the stylesheet
	 */
	private void writeIds(PrintWriter writer, Stylesheet style) {
		for (ID id : style.ids) {
			writer.println("#" + id.getValue() + " {");
			for (Attribute a : id.getAttribs()) {
				writer.println("\t" + a.getKey() + " : " + a.getValue() + ";");
			}
			writer.println("}\n");
		}
	}

	/**
	 * Write the classes.
	 * 
	 * @param writer the PrintWriter object
	 * @param style  the stylesheet
	 */
	private void writeClasses(PrintWriter writer, Stylesheet style) {
		for (Class c : style.classes) {
			for (PseudoClass p : c.getPseudoclasses()) {
				writer.print("." + c.getName() + p.build() + " {\n");
				for (Attribute a : c.getAttribs()) {
					writer.println("\t" + a.getKey() + " : " + a.getValue() + ";");
				}
				writer.println("}\n");
			}
		}
	}

}
