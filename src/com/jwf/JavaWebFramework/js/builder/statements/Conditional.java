package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;
import com.jwf.JavaWebFramework.misc.testing.Logging;

public class Conditional extends Statement {

	// TODO: This is not going to work.
	// Fix this!!!!!!!!
	
	public static final int EQU = 0;
	public static final int NEQ = 1;
	public static final int GTR = 2;
	public static final int LES = 3;
	public static final int LEQ = 4;
	public static final int GEQ = 5;
	
	public static final int AND = -1;
	public static final int OR = -2;
	public static final int NOT = -3;
	
	public String item1;
	public String item2;
	public int condition;
	public Statement trueStatement;
	public Statement falseStatement;
	
	public Conditional (String item1, String item2, int condition, Statement trueStatement) {
		this.item1 = item1;
		this.item2 = item2;
		this.condition = condition;
		this.trueStatement = trueStatement;
		switch (condition) {
		case 0:
			this.body = "if ("+ item1 + "==" + item2 +") " + trueStatement + ";";
			break;
		case 1:
			this.body = "if (" + item1 + "!=" + item2 + ") " + trueStatement + ";";
			break;
		case 2:
			this.body = "if (" + item1 + ">" + item2 + ") " + trueStatement + ";";
			break;
		case 3:
			this.body = "if (" + item1 + "<" + item2 + ") " + trueStatement + ";";
			break;
		case 4:
			this.body = "if (" + item1 + "<=" + item2 + ") " + trueStatement + ";";
			break;
		case 5:
			this.body = "if (" + item1 + ">=" + item2 + ") " + trueStatement + ";";
			break;
		default:
			Logging.LogError("Invalid condition code: " + condition);
			break;
		}
	}
	
	public Conditional (String item1, String item2, int condition, Statement trueStatement, Statement falseStatement) {
		this.item1 = item1;
		this.item2 = item2;
		this.condition = condition;
		this.trueStatement = trueStatement;
		this.falseStatement = falseStatement;
		switch (condition) {
		case 0:
			this.body = "if ("+ item1 + "==" + item2 +") " + trueStatement + "; else " + falseStatement + ";";
			break;
		case 1:
			this.body = "if (" + item1 + "!=" + item2 + ") " + trueStatement + "; else " + falseStatement + ";";
			break;
		case 2:
			this.body = "if (" + item1 + ">" + item2 + ") " + trueStatement + "; else " + falseStatement + ";";
			break;
		case 3:
			this.body = "if (" + item1 + "<" + item2 + ") " + trueStatement + "; else " + falseStatement + ";";
			break;
		case 4:
			this.body = "if (" + item1 + "<=" + item2 + ") " + trueStatement + "; else " + falseStatement + ";";
			break;
		case 5:
			this.body = "if (" + item1 + ">=" + item2 + ") " + trueStatement + "; else " + falseStatement + ";";
			break;
		default:
			Logging.LogError("Invalid condition code: " + condition);
			break;
		}
	}
	
	public Conditional (Conditional conditional1, Conditional conditional2, int joiner) {
		switch (joiner) {
		case -1:
			break;
		case -2:
			break;
		case -3:
			break;
		default:
			break;
		}
	}

	@Override
	public String build() {
		return this.body;
	}
	
}
