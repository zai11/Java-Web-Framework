package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

public class FunctionCall extends Statement {

	String funcName = "";
	List<Object> params = new ArrayList<>();
	
	public FunctionCall(String funcName) {
		this.funcName = funcName;
	}
	
	public FunctionCall(String funcName, Object... params) {
		this.funcName = funcName;
		for (Object param : params) {
			this.params.add(param);
		}
	}
	
	@Override
	public String build() {
		this.body = funcName + "();";
		return this.body;
	}
}