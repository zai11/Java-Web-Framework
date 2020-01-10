package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An abstract representation of a builder.
 * All asset builders will inherit from this class.
 * @param <T>	The type of builder
 */
public abstract class Builder<T> {

	protected List<Class> classes = new ArrayList<Class>();
	protected ID id;
	
	public abstract Asset build();
	
	public abstract Class buildClass();
	
	public abstract ID buildID();
}
