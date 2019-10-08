package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An abstract representation of an Asset.
 * All assets will inherit from this class.
 */
public abstract class Asset {
	
	protected List<Class> classes = new ArrayList<Class>();
	protected ID id;
	
	public abstract String buildLine();
	
}
