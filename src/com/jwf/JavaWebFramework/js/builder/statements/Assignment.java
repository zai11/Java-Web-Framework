package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A javascript assignment
 * @param	<T>	The type of assignment
 */
public class Assignment<T> extends Statement {

	String varName = "";
	T value;

	/**
	 * Constructs an assignment statement using the provided variables.
	 * @param 	varName	the name of the variable
	 * @param 	value	the value of the variable
	 */
	public Assignment(String varName, T value) {
		this.varName = varName;
		this.value = value;
	}

	/**
	 * Builds the body of the assignment.
	 * @return	the body of the assignment
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String build() {
		if (value instanceof String && !((String) value).contains("@var")) {
			this.body = this.varName + " = \"" + this.value + "\";";
		} else {
			if (value instanceof String && ((String) this.value).contains("@var"))
				this.value = (T) this.value.toString().substring(5);
			this.body = this.varName + " = " + this.value + ";";
		}
		return this.body;
	}
}
