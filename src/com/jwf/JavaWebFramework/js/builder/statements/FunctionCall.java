package com.jwf.JavaWebFramework.js.builder.statements;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;

/**
 * A javascript function call.
 * i.e. testFunction();
 */
public class FunctionCall extends Statement {

	String funcName = "";
	List<Object> params = new ArrayList<>();
	
	/**
	 * Constructs a function call using the provided parameters.
	 * @param	funcName	the name of the function to be called
	 */
	public FunctionCall(String funcName) {
		this.funcName = funcName;
	}
	
	/**
	 * Constructs a function call using the provided parameters.
	 * @param 	funcName	the name of the function to be called
	 * @param 	params		any parameters to be passed
	 */
	public FunctionCall(String funcName, Object... params) {
		this.funcName = funcName;
		for (Object param : params) {
			this.params.add(param);
		}
	}
	
	/**
	 * Builds the body of the function call.
	 * @return	the body of the function call
	 */
	@Override
	public String build() {
		this.body = funcName + "();";
		return this.body;
	}
}