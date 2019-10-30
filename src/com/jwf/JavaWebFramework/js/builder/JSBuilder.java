package com.jwf.JavaWebFramework.js.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import com.jwf.JavaWebFramework.main.SiteConfig;
import com.jwf.JavaWebFramework.main.Website;

public class JSBuilder {

	Website website;
	private final String OUTPUT_PATH = Paths.get(".").toAbsolutePath().normalize().toString() + "/Output Files/";
	
	public JSBuilder (Website website) {
		this.website = website;
	}
	
	public void build() throws FileNotFoundException, UnsupportedEncodingException {
		for (JSFile jsFile : website.jsFiles) {
			File file = new File(OUTPUT_PATH + '/' + SiteConfig.NAME + "/res/js/" + jsFile.getName() + ".js");
			file.getParentFile().mkdirs();
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.close();
		}
	}
}
