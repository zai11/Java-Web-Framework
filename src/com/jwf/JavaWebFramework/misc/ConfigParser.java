package com.jwf.JavaWebFramework.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.main.SiteConfig;
import com.jwf.JavaWebFramework.main.Website;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * The config parser - reads and parses the config file.
 */
public class ConfigParser {

	String address;
	Website site;
	List<String> lines = new ArrayList<>();

	/**
	 * Constructs the config parser using the provided parameters.
	 * @param 	site	the website
	 * @param 	address	the address of the config file
	 */
	public ConfigParser(Website site, String address) {
		this.address = Paths.get(".").toAbsolutePath().normalize().toString() + "/Input Files/conf/"
				+ address;
		this.site = site;
	}

	/**
	 * Reads the config file.
	 */
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

	/**
	 * Parses the config file.
	 */
	public void parse() {
		readFile();
		for (String line : lines) {
			String prefix = line.split("=")[0];
			switch(prefix) {
			case "title":
				SiteConfig.NAME = line.substring(6);
				break;
			case "extension":
				SiteConfig.EXTENSION = line.substring(10);
				break;
			case "clear_output_dir":
				SiteConfig.CLEAR_OUTPUT_DIR = Boolean.valueOf(line.substring(17));
				break;
			case "enable_css":
				SiteConfig.ENABLE_CSS = Boolean.valueOf(line.substring(11));
				break;
			case "enable_images":
				SiteConfig.ENABLE_IMAGES = Boolean.valueOf(line.substring(14));
				break;
			case "enable_js":
				SiteConfig.ENABLE_JS = Boolean.valueOf(line.substring(10));
				break;
			case "import_config":
				SiteConfig.IMPORT_CONFIG = Boolean.valueOf(line.substring(14));
				break;
			default:
				Logging.LogWarning("Invalid config statement: " + line);
				break;
			}
		}
	}
}
