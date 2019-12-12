package com.jwf.JavaWebFramework.main;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.AssetType;
import com.jwf.JavaWebFramework.js.builder.JSFile;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Stylesheet;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An object representation of a HTML webpage.
 * All assets will be attached to this.
 * <br />
 * See <a href="">Documentation</a>
 */
public class Page {

	private List<Asset> assets = new ArrayList<>();
	private String name;
	private String title;
	private List<Stylesheet> stylesheets = new ArrayList<>();
	private List<JSFile> jsFiles = new ArrayList<>();
	
	/**
	 * Constructs a page using the given parameters.
	 * @param name the name of the page
	 */
	public Page(String name) {
		this.name = name;
		this.title = name;
	}
	
	/**
	 * Gets the name of the page.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the page to the given parameter.
	 * @param newName the new name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Gets the title of the page.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of the page to the given parameter.
	 * @param newTitle the new title
	 */
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	/**
	 * Gets a list of all child assets.
	 * @return the child assets
	 */
	public List<Asset> getAssets() {
		return assets;
	}
	
	/**
	 * Adds an asset to the page.
	 * @param asset the new asset
	 */
	public void add (Asset asset) {
		assets.add(asset);
	}

	/**
	 * Adds a stylesheet to the page.
	 * @param style the new stylesheet
	 */
	public void addStyle(Stylesheet style) {
		stylesheets.add(style);
	}
	
	/**
	 * Gets the current stylesheet attached to the page.
	 * @return the stylesheet
	 */
	public List<Stylesheet> getStyles() {
		return stylesheets;
	}
	
	public Asset findAsset(AssetType type, String cl) {
		for (Asset asset : assets) {
			if (type == asset.assetType) {
				for (Class c : asset.classes) {
					if (c.getName() == cl)
						return asset;
				}
			}
		}
		return null;
	}
	
	public void addJSFile(JSFile jsFile) {
		JWF.WEBSITE.jsFiles.add(jsFile);
		this.jsFiles.add(jsFile);
	}
	
	public List<JSFile> getJSFiles() {
		return jsFiles;
	}
	
	public Class findClass(String className) {
		for (Stylesheet style : stylesheets) {
			for (Class c : style.classes) {
				if (c.getName() == className) {
					return c;
				}
			}
		}
		Logging.LogError("Unable to find the class: " + className + ".");
		return null;
	}
	
	public ID findID(String idValue) {
		for (Stylesheet style : stylesheets) {
			for (ID id : style.ids) {
				if (id.getValue() == idValue) {
					return id;
				}
			}
		}
		Logging.LogError("Unable to find the id: " + idValue + ".");
		return null;
	}
}
