package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.ScriptBuilder;
import com.jwf.JavaWebFramework.js.builder.JSFile;
import com.jwf.JavaWebFramework.js.builder.Statement;

public class Conditional extends Statement {
	
	private String condition;
	private List<Statement> trueStatements = new ArrayList<>();
	private List<Statement> falseStatements = new ArrayList<>();
	private ScriptBuilder p1;
	private JSFile p2;
	
	public Conditional(String condition, List<Statement> trueStatements, ScriptBuilder parent) {
		this.condition = condition;
		this.trueStatements = trueStatements;
		this.p1 = parent;
	}
	
	public Conditional(String condition, List<Statement> trueStatements, List<Statement> falseStatements, ScriptBuilder parent) {
		this.condition = condition;
		this.trueStatements = trueStatements;
		this.falseStatements = falseStatements;
		this.p1 = parent;
	}
	
	public Conditional(String condition, List<Statement> trueStatements, JSFile parent) {
		this.condition = condition;
		this.trueStatements = trueStatements;
		this.p2 = parent;
	}
	
	public Conditional(String condition, List<Statement> trueStatements, List<Statement> falseStatements, JSFile parent) {
		this.condition = condition;
		this.trueStatements = trueStatements;
		this.falseStatements = falseStatements;
		this.p2 = parent;
	}

	@Override
	public String build() {
		this.body = "";
		this.condition = checkForVars(this.condition);
		this.body += "if (" + this.condition + ") {\n";
		for (Statement statement : this.trueStatements) {
			this.body += "\t\t\t\t" + statement.build() + "\n";
		}
		this.body += "\t\t\t}";
		if (!this.falseStatements.isEmpty()) {
			this.body += "\t\t\telse {";
			for (Statement statement : this.falseStatements) {
				this.body += "\t\t\t\t" + statement.build() + "\n";
			}
			this.body += "\t\t\t}";
		}
		return this.body;
	}
	
	String checkForVars(String str) {
		String result = "";
		String[] chunks = str.split(" ");
		boolean found = false;
		for (int i = 0; i < chunks.length; i++) {
			String temp = chunks[i];
			if (chunks[i].equals("@var")) {
				found = true;
				continue;
			}
			if (found) {
				if (p1 != null)
					temp = p1.findVariable(chunks[i]).getValue().toString();
				else
					temp = p2.findVariable(chunks[i]).getValue().toString();
				found = false;
			}
			result += temp;
		}
		return result;
	}
	
}
