package com.jwf.JavaWebFramework.js.builder;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.AssetType;
import com.jwf.JavaWebFramework.main.Page;

public class JSFile {

	Page parent;
	private String name;
	List<PrimitiveVariable<?>> variables = new ArrayList<>();
	
	public JSFile(Page parent, String name) {
		this.name = name;
		this.parent = parent;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Asset selectAsset(AssetType type, String cl) {
		Asset asset = parent.findAsset(type, cl);
		return asset;
	}
	
	public void addVariable() {
		
	}
	
	public List<PrimitiveVariable<?>> getVariables() {
		return variables;
	}
	
	public PrimitiveVariable<?> getVariable(String name) {
		for (PrimitiveVariable<?> variable : variables) {
			if (variable.name.equals(name)) {
				return variable;
			}
		}
		System.out.println("[!] Error: could not find variable: " + name);
		return null;
	}
}
