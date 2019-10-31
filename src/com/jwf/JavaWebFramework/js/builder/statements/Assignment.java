package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class Assignment extends Statement {

	String varName = "";
	String value;
	
	public Assignment (String varName, String value) {
		this.varName = varName;
		this.value = value;
		this.body = varName + " = " + value + ";";
	}
	
	@Override
	public String build() {
		return this.body;
	}
}
