package com.jwf.JavaWebFramework.js.builder.statements;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class Assignment<E> extends Statement {

	String varName = "";
	E value;

	@SuppressWarnings("unchecked")
	public Assignment(String varName, E value) {
		this.varName = varName;
		this.value = value;
		if (value instanceof String && !((String) value).contains("@var")) {
			this.body = this.varName + " = \"" + this.value + "\";";
		} else {
			if (value instanceof String && ((String) this.value).contains("@var"))
				this.value = (E) this.value.toString().substring(5);
			this.body = this.varName + " = " + this.value + ";";
		}
	}
	
	@SuppressWarnings("unchecked")
	public Assignment(String varName, E value, Statement parent) {
		this.varName = varName;
		this.value = value;
		if (value instanceof String && !((String) value).contains("@var")) {
			this.body = this.varName + " = \"" + this.value + "\";";
		} else {
			if (value instanceof String && ((String) this.value).contains("@var"))
				this.value = (E) this.value.toString().substring(5);
			this.body = this.varName + " = " + this.value + ";";
		}
	}

	@Override
	public String build() {
		return this.body;
	}
}
