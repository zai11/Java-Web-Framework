package com.jwf.JavaWebFramework.js.builder;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;

import com.jwf.JavaWebFramework.main.JWF;
import com.jwf.JavaWebFramework.main.SiteConfig;

/**
 * A JSFile Builder - Writes to each javascript file.
 * @see JSFile
 */
public class JSFileBuilder {

	public JSFile file;
	private final String OUTPUT_PATH = Paths.get(".").toAbsolutePath().normalize().toString() + "/Output Files/";
	
	/**
	 * Builds each javascript file.
	 */
	public void build() {
		for (JSFile jsFile : JWF.WEBSITE.jsFiles) {
			File f = new File(OUTPUT_PATH + '/' + SiteConfig.NAME + "/res/js/" + jsFile.getName() + ".js");
			f.getParentFile().mkdirs();
			try {
			PrintWriter writer = new PrintWriter(f, "UTF-8");
			writeVariables(writer, jsFile);
			writeStatements(writer, jsFile);
			writer.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Writes the variables to the javascript file.
	 * @param 	writer	the PrintWriter object
	 * @param 	jsFile	the javascript file
	 */
	public void writeVariables(PrintWriter writer, JSFile jsFile) {
		for (PrimitiveVariable<?> var : jsFile.variables) {
			if (var.getValue() instanceof String) {
				writer.println("var " + var.getName() + " = \"" + var.getValue() + "\";");
			}
			else {
				writer.println("var " + var.getName() + " = " + var.getValue() + ";");
			}
		}
	}
	
	/**
	 * Writes the statements to the javascript file.
	 * @param 	writer	the PrintWriter object
	 * @oaram 	jsFile	the javascript file
	 */
	public void writeStatements(PrintWriter writer, JSFile jsFile) {
		for (Statement statement : jsFile.statements) {
			writer.print(statement.body);
		}
	}
}
