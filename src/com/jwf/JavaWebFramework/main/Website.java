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
	
	public Website() {}
	
	public void addStyle(Stylesheet style) {
		this.stylesheets.add(style);
	}
	
	public void addPage(Page page) {
		this.pages.add(page);
	}
	
	public void addJSFile(JSFile jsFile) {
		this.jsFiles.add(jsFile);
	}
}
