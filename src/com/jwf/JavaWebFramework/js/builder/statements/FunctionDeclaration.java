package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A function declaration.
 * e.g. function testFunction () { }
 */
public class FunctionDeclaration extends Statement {

	String funcName = "";
	List<Statement> statements = new ArrayList<>();
	List<String> params = new ArrayList<>();
	
	/**
	 * Constructs a function declaration using the provided parameters.
	 * @param	funcName	the name of the function
	 * @param	params		any parameters to be passed
	 */
	public FunctionDeclaration(String funcName, String... params) {
		this.funcName = funcName;
		for (String param : params) {
			this.params.add(param);
		}
		build();
	}
	
	/**
	 * Adds a statement to the function declaration.
	 * @param 	statement	the statement to be added
	 * @return	the FunctionDeclaration object
	 */
	public FunctionDeclaration addStatement(Statement statement) {
		statements.add(statement);
		build();
		return this;
	}
	
	/**
	 * Gets the name of the function.
	 * @return	the name of the function
	 */
	public String getName() {
		return this.funcName;
	}
	
	/**
	 * Builds the body of the function declaration.
	 * @return	the body of the function declaration
	 */
	@Override
	public String build() {
		this.body = "function " + this.funcName + "(";
		for (int i = 0; i < params.size(); i++) {
			if (i != params.size()-1)
				this.body += params.get(i) + ", ";
			else
				this.body += params.get(i);
		}
		this.body += ") {\n";
		for (Statement statement : statements)
			this.body += "\t\t\t\t" + statement.build() + "\n";
		this.body += "\t\t\t}";
		return this.body;
	}

}
