package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class Loop extends Statement {
	
	private int num;
	private List<Statement> statements;
	
	// This is a for loop.
	public Loop(int num, List<Statement> statements) {
		this.num = num;
		this.statements = statements;
	}
	
	public void addStatement(Statement statement) {
		this.statements.add(statement);
	}
	
	@Override
	public String build() {
		this.body = "for (int i = 0; i < " + num + "; i++) {\n";
		for (Statement statement : statements) {
			this.body += "\t\t\t\t" + statement.build() + "\n";
		}
		this.body += "\t\t\t}";
		return this.body;
	}
}