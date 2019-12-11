package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class VariableDeclaration extends Statement {
	
	String name;
	Object value;
	
	public VariableDeclaration(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String build() {
		this.body = "var " + this.name + " = " + value + ";";
		return this.body;
	}
}
