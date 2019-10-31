package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * An abstract representation of an Asset.
 * All assets will inherit from this class.
 */
public abstract class Asset {
	
	public AssetType assetType;
	
	public List<Class> classes = new ArrayList<Class>();
	public ID id;
	
	public abstract String buildLine();
	
	public Asset setInnerHTML(String html) {
		return this;
	}
	
}
