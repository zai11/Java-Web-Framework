package com.jwf.JavaWebFramework.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.js.builder.JSFile;
import com.jwf.JavaWebFramework.styling.Stylesheet;

/**
 * Builds the website.
 */
public class PageBuilder {

	private Website website;

	private final String ROOT_PATH = Paths.get(".").toAbsolutePath().normalize().toString();
	private final String OUTPUT_PATH = ROOT_PATH + "\\Output Files\\";
	private final String INPUT_PATH = ROOT_PATH + "\\Input Files\\";

	/**
	 * Constructs the pagebuilder object using the given parameter.
	 * 
	 * @param website the website that will be built
	 */
	public PageBuilder(Website website) {
		this.website = website;
	}

	/**
	 * Builds the website.
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void build() {
		if (SiteConfig.CLEAR_OUTPUT_DIR)
			deleteOutputDir(new File(OUTPUT_PATH));
		buildDirectories();
		copyInputFiles();
		for (Page page : website.pages) {
			File file = new File(OUTPUT_PATH + SiteConfig.NAME + '\\' + page.getName() + "." + SiteConfig.EXTENSION);
			file.getParentFile().mkdirs();
			try {
				PrintWriter writer = new PrintWriter(file, "UTF-8");
				printHead(writer, page);
				printAssets(writer, page);
				printFoot(writer, page);
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Prints out the HTML of each asset in the webpage.
	 * 
	 * @param writer the PrintWriter object
	 * @param page   the webpage
	 */
	private void printAssets(PrintWriter writer, Page page) {
		for (Asset asset : page.getAssets()) {
			writer.println("\t\t" + asset.buildLine());
		}
	}

	/**
	 * Prints the head of the document.
	 * 
	 * @param writer the PrintWriter object
	 * @param page   the webpage
	 */
	private void printHead(PrintWriter writer, Page page) {
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("\t<head>");
		if (page.getStyles() != null) {
			for (Stylesheet style : page.getStyles()) {
				writer.println("\t\t<link rel='stylesheet' type='text/css' href='res/css/" + style.getName() + ".css'>");
			}
		}
		if (page.getJSFiles() != null) {
			for (JSFile jsFile : page.getJSFiles()) {
				writer.println("\t\t<script type='text/javascript' src='res/js/" + jsFile.getName() + ".js'></script>");
			}
		}
		writer.println("\t\t<title>" + page.getTitle() + "</title>");
		writer.println("\t</head>");
		writer.println("\t<body>");
	}

	/**
	 * Print the foot of the document.
	 * 
	 * @param writer the PrintWriter object
	 * @param page   the webpage
	 */
	private void printFoot(PrintWriter writer, Page page) {
		writer.println("\t</body>");
		writer.println("</html>");
	}

	/**
	 * Builds the necessary directories.
	 */
	private void buildDirectories() {
		File root = new File(OUTPUT_PATH + SiteConfig.NAME);
		File res = new File(root.getAbsolutePath() + "\\res");
		File images = new File(res.getAbsolutePath() + "\\images");
		File css = new File(res.getAbsolutePath() + "\\css");
		File js = new File(res.getAbsolutePath() + "\\js");

		if (!root.exists())
			root.mkdir();

		if (!res.exists() && (SiteConfig.ENABLE_CSS || SiteConfig.ENABLE_IMAGES || SiteConfig.ENABLE_JS))
			res.mkdir();

		if (!images.exists() && SiteConfig.ENABLE_IMAGES)
			images.mkdir();

		if (!css.exists() && SiteConfig.ENABLE_CSS)
			css.mkdir();

		if (!js.exists() && SiteConfig.ENABLE_JS)
			js.mkdir();
	}

	/**
	 * Copies the input files (images, etc.) to the "Output Files" directory
	 */
	private void copyInputFiles() {
		File css = new File(INPUT_PATH + "css");
		File images = new File(INPUT_PATH + "images");
		File js = new File(INPUT_PATH + "js");
		File conf = new File(INPUT_PATH + "conf");
		try {
			if (SiteConfig.ENABLE_CSS)
				FileUtils.copyDirectory(css, new File(OUTPUT_PATH + SiteConfig.NAME + "\\res\\css\\"));
			if (SiteConfig.ENABLE_IMAGES)
				FileUtils.copyDirectory(images, new File(OUTPUT_PATH + SiteConfig.NAME + "\\res\\images\\"));
			if (SiteConfig.ENABLE_JS)
				FileUtils.copyDirectory(js, new File(OUTPUT_PATH + SiteConfig.NAME + "\\res\\js\\"));
			if (SiteConfig.IMPORT_CONFIG)
				FileUtils.copyDirectory(conf, new File(OUTPUT_PATH + SiteConfig.NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the output directory and all of the files within it.
	 * @param folder	The address of the output directory
	 */
	private void deleteOutputDir(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteOutputDir(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}
}
