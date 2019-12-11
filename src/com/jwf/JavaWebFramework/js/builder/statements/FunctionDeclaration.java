package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class FunctionDeclaration extends Statement {

	String funcName = "";
	List<Statement> statements = new ArrayList<>();
	List<String> params = new ArrayList<>();
	
	public FunctionDeclaration(String funcName, String... params) {
		this.funcName = funcName;
		for (String param : params) {
			this.params.add(param);
		}
		build();
	}
	
	public FunctionDeclaration addStatement(Statement statement) {
		statements.add(statement);
		build();
		return this;
	}
	
	public String getName() {
		return this.funcName;
	}
	
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
