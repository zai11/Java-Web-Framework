package com.jwf.JavaWebFramework.main;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.AssetType;
import com.jwf.JavaWebFramework.styling.Stylesheet;
import com.jwf.JavaWebFramework.styling.Class;

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
}
