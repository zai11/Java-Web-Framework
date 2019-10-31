package com.jwf.JavaWebFramework.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.main.SiteConfig;
import com.jwf.JavaWebFramework.main.Website;
import com.jwf.JavaWebFramework.misc.testing.Logging;

public class ConfigParser {

	String address;
	Website site;
	List<String> lines = new ArrayList<>();

	public ConfigParser(Website site, String address) {
		this.address = Paths.get(".").toAbsolutePath().normalize().toString() + "/Input Files/conf/"
				+ address;
		this.site = site;
	}

	private void readFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(address));
			String line = br.readLine();
			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			Logging.LogWarning("Unable to find config file at: " + address + ".");
		}
	}

	public void parse() {
		readFile();
		for (String line : lines) {
			if (line.startsWith("title"))
				SiteConfig.NAME = line.substring(6);
			
			if (line.startsWith("extension"))
				SiteConfig.EXTENSION = line.substring(10);
			
			if (line.startsWith("clear_output_dir"))
				SiteConfig.CLEAR_OUTPUT_DIR = Boolean.valueOf(line.substring(17));
			
			if (line.startsWith("enable_css"))
				SiteConfig.ENABLE_CSS = Boolean.valueOf(line.substring(11));
			
			if (line.startsWith("enable_images"))
				SiteConfig.ENABLE_IMAGES = Boolean.valueOf(line.substring(14));
			
			if (line.startsWith("enable_js"))
				SiteConfig.ENABLE_JS = Boolean.valueOf(line.substring(10));
			
			if (line.startsWith("import_config"))
				SiteConfig.IMPORT_CONFIG = Boolean.valueOf(line.substring(14));
				
		}
	}
}
