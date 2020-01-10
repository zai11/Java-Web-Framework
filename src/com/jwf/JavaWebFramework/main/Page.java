package com.jwf.JavaWebFramework.main;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.js.builder.JSFile;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Stylesheet;

/**
 * An object representation of a HTML webpage.
 * All assets will be attached to this.
 * <br />
 * See <a href="../../Documentation/HTML/pages.html">Documentation</a>
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
	 * @return	the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the page to the given parameter.
	 * @param	newName	the new name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Gets the title of the page.
	 * @return	the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title of the page to the given parameter.
	 * @param 	newTitle	the new title
	 */
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	/**
	 * Gets a list of all child assets.
	 * @return	the child assets
	 */
	public List<Asset> getAssets() {
		return assets;
	}
	
	/**
	 * Adds an asset to the page.
	 * @param	asset	the new asset
	 */
	public void add (Asset asset) {
		assets.add(asset);
	}

	/**
	 * Adds a stylesheet to the page.
	 * @param 	style 	the new stylesheet
	 */
	public void addStyle(Stylesheet style) {
		stylesheets.add(style);
	}
	
	/**
	 * Gets the current stylesheet attached to the page.
	 * @return	the stylesheet
	 */
	public List<Stylesheet> getStyles() {
		return stylesheets;
	}
	
	/**
	 * Find an asset with a given class.
	 * @param 	type	the type of asset
	 * @param	cl		the class
	 * @return	the found asset
	 */
	public Asset findAsset(Assets type, String cl) {
		for (Asset asset : assets) {
			if (type == asset.assetType) {
				for (Class c : asset.classes) {
					if (c.getName() == cl)
						return asset;
				}
			}
		}
		Logging.LogError("Unable to find asset of type: " + type + " and class: " + cl);
		return null;
	}
	
	/**
	 * Adds a javascript file to the page.
	 * @param 	jsFile	the javascript file
	 */
	public void addJSFile(JSFile jsFile) {
		JWF.WEBSITE.jsFiles.add(jsFile);
		this.jsFiles.add(jsFile);
	}
	
	/**
	 * Gets a list of all javascript files on the page.
	 * @return	the list of javascript files
	 */
	public List<JSFile> getJSFiles() {
		return jsFiles;
	}
	
	/**
	 * Finds a class with the given name.
	 * @param 	className	the name to search for
	 * @return	the class that was found
	 */
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
	
	/**
	 * Finds an id with the given value.
	 * @param 	idValue	the value to search for
	 * @return	the id that was found
	 */
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
