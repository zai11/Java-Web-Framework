package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A javascript loop.
 * e.g. for, while, etc.
 */
public class Loop extends Statement {
	
	private short type;
	private int num;
	private List<Statement> statements;
	
	private String varName, condition;
	private int initValue;
	private boolean increment;
	
	private String collectionName;
	
	/**
	 * Constructs a loop using the provided parameters.
	 * @param num			the number of times the loop will repeat
	 * @param statements	a list of statements to be looped over
	 */
	public Loop(int num, List<Statement> statements) {
		this.type = 0;
		this.num = num;
		this.statements = statements;
	}
	
	/**
	 * Constructs a loop using the provided parameters
	 * @param varName		the name of the internal variable
	 * @param initValue		the initial value of the variable
	 * @param condition		the condition to check the variable against
	 * @param increment		whether the variable should increment (true) or decrement (false)
	 * @param statements	a list of statements to be looped over
	 */
	public Loop(String varName, int initValue, String condition, boolean increment, List<Statement> statements) {
		this.type = 1;
		this.varName = varName;
		this.initValue = initValue;
		this.condition = condition;
		this.increment = increment;
		this.statements = statements;
	}
	
	/**
	 * Constructs a loop using the provided parameters
	 * @param varName			the name of the internal variable
	 * @param collectionName	the collection that should be searched over
	 * @param statements		a list of statements to be looped over
	 */
	public Loop(String varName, String collectionName, List<Statement> statements) {
		this.type = 2;
		this.varName = varName;
		this.collectionName = collectionName;
		this.statements = statements;
	}
	
	/**
	 * Constructs a loop using the provided parameters
	 * @param condition		the condition to be checked
	 * @param statements	a list of statements to be looped over
	 */
	public Loop(String condition, List<Statement> statements) {
		this.type = 3;
		this.condition = condition;
		this.statements = statements;
	}
	
	/**
	 * Builds the body of the loop.
	 * @return	the body of the loop
	 */
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