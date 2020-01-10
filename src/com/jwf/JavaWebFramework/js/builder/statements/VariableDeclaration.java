package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A javascript variable declaration.
 */
public class VariableDeclaration extends Statement {
	
	String name;
	Object value;
	
	/**
	 * Constructs a variable declaration using the provided variables.
	 * @param name	the name of the variable
	 * @param value	the value of the variable
	 */
	public VariableDeclaration(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Builds the body of the variable declaration.
	 * @return	the body of the variable declaration
	 */
	@Override
	public String build() {
		this.body = "var " + this.name + " = " + value + ";";
		return this.body;
	}
}
