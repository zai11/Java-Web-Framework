package com.jwf.JavaWebFramework.main;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.JSFile;
import com.jwf.JavaWebFramework.styling.Stylesheet;

/**
 * The location all pages and styles are created.
 */
public class Website {

	public List<Page> pages = new ArrayList<>();
	public List<Stylesheet> stylesheets = new ArrayList<>();
	public List<JSFile> jsFiles = new ArrayList<>();
	
	/**
	 * Adds a stylesheet to the website.
	 * @param 	style	the stylesheet
	 */
	public void addStyle(Stylesheet style) {
		this.stylesheets.add(style);
	}
	
	/**
	 * Adds a page to the website.
	 * @param 	page	the page
	 */
	public void addPage(Page page) {
		this.pages.add(page);
	}
	
	/**
	 * Adds a javascript file to the website.
	 * @param 	jsFile	the javascript file
	 */
	public void addJSFile(JSFile jsFile) {
		this.jsFiles.add(jsFile);
	}
}
