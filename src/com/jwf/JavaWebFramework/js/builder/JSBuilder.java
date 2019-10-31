package com.jwf.JavaWebFramework.js.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.AssetType;
import com.jwf.JavaWebFramework.js.builder.statements.Assignment;
import com.jwf.JavaWebFramework.js.builder.statements.Conditional;
import com.jwf.JavaWebFramework.main.Page;
import com.jwf.JavaWebFramework.main.SiteConfig;
import com.jwf.JavaWebFramework.main.Website;

public class JSBuilder {

	Website website;
	JSFile file;
	private final String OUTPUT_PATH = Paths.get(".").toAbsolutePath().normalize().toString() + "/Output Files/";
	
	public JSBuilder (Website website, String name) {
		this.website = website;
		file = new JSFile(name);
	}
	
	public void build() throws FileNotFoundException, UnsupportedEncodingException {
		for (JSFile jsFile : website.jsFiles) {
			File file = new File(OUTPUT_PATH + '/' + SiteConfig.NAME + "/res/js/" + jsFile.getName() + ".js");
			file.getParentFile().mkdirs();
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.close();
		}
	}
	
	public Asset selectAsset(AssetType type, String cl) {
		Asset asset = null;
		for (Page page : website.pages) {
			asset = page.findAsset(type, cl);
		}
		return asset;
	}
	
	public JSBuilder createVariable(String name, String value) {
		PrimitiveVariable<String> var = new PrimitiveVariable<>(name, value);
		file.addVariable(var);
		return this;
	}
	
	public JSBuilder createVariable(String name, float value) {
		PrimitiveVariable<Float> var = new PrimitiveVariable<>(name, value);
		file.addVariable(var);
		return this;
	}
	
	public JSBuilder createVariable(String name, int value) {
		PrimitiveVariable<Integer> var = new PrimitiveVariable<>(name, value);
		file.addVariable(var);
		return this;
	}
	
	public JSBuilder createVariable(String name, boolean value) {
		PrimitiveVariable<Boolean> var = new PrimitiveVariable<>(name, value);
		file.addVariable(var);
		return this;
	}
	
	public JSBuilder createAssignment(String varName, String value) {
		Assignment assignment = new Assignment(varName, value);
		file.addStatement(assignment);
		return this;
	}
	
	public JSBuilder createConditional(String item1, String item2, int condition, Statement trueStatement, Statement falseStatement) {
		Conditional conditional = new Conditional(item1, item2, condition, trueStatement, falseStatement);
		file.addStatement(conditional);
		return this;
	}
}
