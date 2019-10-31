package com.jwf.JavaWebFramework.js.builder;

import java.util.ArrayList;
import java.util.List;

public class JSFile {

	private String name;
	List<PrimitiveVariable<?>> variables = new ArrayList<>();
	List<Statement> statements = new ArrayList<>();
	
	public JSFile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addVariable(PrimitiveVariable<?> var) {
		this.variables.add(var);
	}
	
	public List<PrimitiveVariable<?>> getVariables() {
		return variables;
	}
	
	public PrimitiveVariable<?> findVariable(String name) {
		for (PrimitiveVariable<?> variable : variables) {
			if (variable.name.equals(name)) {
				return variable;
			}
		}
		System.out.println("[!] Error: could not find variable: " + name);
		return null;
	}
	
	public void addStatement(Statement statement) {
		this.statements.add(statement);
	}
	
	public List<Statement> getStatements() {
		return statements;
	}
	
}
