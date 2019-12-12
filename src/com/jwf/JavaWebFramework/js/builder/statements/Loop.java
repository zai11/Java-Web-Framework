package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class Loop extends Statement {
	
	private short type;
	private int num;
	private List<Statement> statements;
	
	private String varName, condition;
	private int initValue;
	private boolean increment;
	
	private String collectionName;
	
	public Loop(int num, List<Statement> statements) {
		this.type = 0;
		this.num = num;
		this.statements = statements;
	}
	
	public Loop(String varName, int initValue, String condition, boolean increment, List<Statement> statements) {
		this.type = 1;
		this.varName = varName;
		this.initValue = initValue;
		this.condition = condition;
		this.increment = increment;
		this.statements = statements;
	}
	
	public Loop(String varName, String collectionName, List<Statement> statements) {
		this.type = 2;
		this.varName = varName;
		this.collectionName = collectionName;
		this.statements = statements;
	}
	
	public Loop(String condition, List<Statement> statements) {
		this.type = 3;
		this.condition = condition;
		this.statements = statements;
	}
	
	@Override
	public String build() {
		switch(this.type) {
		case 0:
			this.body = "for (i = 0; i < " + num + "; i++) {\n";
			break;
		case 1:
			this.body = "for (" + this.varName + " = " + this.initValue + "; " + this.condition + "; ";
			if (this.increment)
				this.body += this.varName + "++";
			else
				this.body += this.varName + "--";
			this.body += ") {\n";
			break;
		case 2:
			this.body = "for (var " + this.varName + " in " + this.collectionName + ") {\n";
			break;
		case 3:
			this.body = "while (" + this.condition + ") {\n";
			break;
		}
		for (Statement statement : this.statements) {
			this.body += "\t\t\t\t" + statement.build() + "\n";
		}
		this.body += "\t\t\t}";
		return this.body;
	}
}