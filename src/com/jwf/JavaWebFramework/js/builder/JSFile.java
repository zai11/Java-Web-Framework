package com.jwf.JavaWebFramework.js.builder;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.statements.Assignment;
import com.jwf.JavaWebFramework.js.builder.statements.Comment;
import com.jwf.JavaWebFramework.js.builder.statements.Conditional;
import com.jwf.JavaWebFramework.js.builder.statements.CustomStatement;
import com.jwf.JavaWebFramework.js.builder.statements.FunctionCall;
import com.jwf.JavaWebFramework.js.builder.statements.FunctionDeclaration;
import com.jwf.JavaWebFramework.js.builder.statements.Loop;
import com.jwf.JavaWebFramework.js.builder.statements.VariableDeclaration;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A javascript file.
 */
public class JSFile {

	private String name;
	List<PrimitiveVariable<?>> variables = new ArrayList<>();
	List<Statement> statements = new ArrayList<>();

	/**
	 * Constructs a javascript file using the provided parameters.
	 * 
	 * @param name the name of the file
	 */
	public JSFile(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the javascript file.
	 * 
	 * @return the name of the file
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the javascript file.
	 * 
	 * @param name the new file name
	 * @return the JSFile object
	 */
	public JSFile setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Adds a statement
	 * 
	 * @param statement
	 * @return the JSFile object
	 */
	public JSFile addStatement(Statement statement) {
		this.statements.add(statement);
		return this;
	}

	/**
	 * Gets a list of all statements in the javascript file.
	 * 
	 * @return a list of statements
	 */
	public List<Statement> getStatements() {
		return statements;
	}

	/**
	 * Adds a variable to the javascript file.
	 * 
	 * @param var the variable to be added
	 * @return the JSFile object
	 */
	public JSFile addVariable(PrimitiveVariable<?> var) {
		this.variables.add(var);
		return this;
	}

	/**
	 * Get a list of all variables in the javascript file.
	 * 
	 * @return a list of variables
	 */
	public List<PrimitiveVariable<?>> getVariables() {
		return this.variables;
	}

	/**
	 * Find the variable with a given name.
	 * 
	 * @param varName the name to search for
	 * @return the variable that was found
	 */
	public PrimitiveVariable<?> findVariable(String varName) {
		for (PrimitiveVariable<?> var : variables) {
			if (var.getName().equals(varName)) {
				return var;
			}
		}
		Logging.LogError("Unable to find variable: " + varName);
		return null;
	}

	/**
	 * Check if a variable with a given name already exists.
	 * 
	 * @param varName the name to search for
	 * @return whether the variable was found (true) or not (false)
	 */
	public boolean checkForVariable(String varName) {
		for (PrimitiveVariable<?> var : variables) {
			if (var.getName().equals(varName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find and update the value of a specified variable.
	 * @param 	varName		the name of the variable to be updated
	 * @param 	newValue	the new value
	 * @return	whether the variable was successfully updated (true) or not (false)
	 */
	public boolean updateVariableValue(String varName, Object newValue) {
		if (checkForVariable(varName)) {
			findVariable(varName).setValue(newValue);
			return true;
		}
		Logging.LogError("Unable to find variable: " + varName);
		return false;
	}

	/**
	 * Creates and adds a variable declaration to the javascript file.
	 * @param 	name	the name of the variable
	 * @param 	value	the value to be set
	 * @return	the JSFile object
	 */
	public JSFile createVariableDeclaration(String name, Object value) {
		VariableDeclaration vardec = new VariableDeclaration(name, value);
		addStatement(vardec);
		PrimitiveVariable<Object> var = new PrimitiveVariable<>(name, value);
		addVariable(var);
		return this;
	}

	/**
	 * Creates and adds an assignment to the javascript file.
	 * @param 	varName	the name of the variable
	 * @param 	value	the value to be set
	 * @return	the JSFile object
	 */
	public JSFile createAssignment(String varName, Object value) {
		Assignment<Object> assignment = new Assignment<>(varName, value);
		addStatement(assignment);
		@SuppressWarnings("unchecked")
		PrimitiveVariable<Object> var = (PrimitiveVariable<Object>) findVariable(varName);
		var.setValue(value);
		return this;
	}

	/**
	 * Creates and adds a function call to the javascript file.
	 * @param 	funcName	the name of the function
	 * @return	the JSFile object
	 */
	public JSFile createFunctionCall(String funcName) {
		FunctionCall funcCall = new FunctionCall(funcName);
		addStatement(funcCall);
		return this;
	}

	/**
	 * Creates and adds a function declaration to the javascript file.
	 * @param 	funcName	the name of the function
	 * @param 	params		any parameters to be passed
	 * @return	the JSFile object
	 */
	public JSFile createFunctionDeclaration(String funcName, String... params) {
		FunctionDeclaration funcDec = new FunctionDeclaration(funcName, params);
		addStatement(funcDec);
		return this;
	}

	/**
	 * Find a function with the given name.
	 * @param 	funcName	the name of the function to be found
	 * @return	the function that was found
	 */
	public FunctionDeclaration findFunction(String funcName) {
		for (Statement statement : statements) {
			if (statement instanceof FunctionDeclaration) {
				if (((FunctionDeclaration) statement).getName().equals(funcName)) {
					return (FunctionDeclaration) statement;
				}
			}
		}
		Logging.LogError("Unable to find function declaration: " + funcName + ".");
		return null;
	}

	/**
	 * Creates and adds a conditional statement to the javascript file.
	 * @param 	condition		the condition to be checked
	 * @param 	trueStatements	a list of statements to be executed if the condition is true
	 * @return	the JSFile object
	 */
	public JSFile createConditional(String condition, List<Statement> trueStatements) {
		Conditional conditional = new Conditional(condition, trueStatements, this);
		addStatement(conditional);
		return this;
	}

	/**
	 * Creates and adds a conditional statement to the javascript file.
	 * @param 	condition		the condition to be checked
	 * @param 	trueStatements	a list of statements to be executed if the condition is true
	 * @param 	falseStatements	a list of statements to be executed if the condition is false
	 * @return	the JSFile object
	 */
	public JSFile createConditional(String condition, List<Statement> trueStatements, List<Statement> falseStatements) {
		Conditional conditional = new Conditional(condition, trueStatements, falseStatements, this);
		addStatement(conditional);
		return this;
	}

	/**
	 * Creates and adds a loop statement to the javascript file.
	 * @param 	num			the number of times the loop will repeat
	 * @param 	statements	a list of statements to be looped over
	 * @return	the JSFile object
	 */
	public JSFile createLoop(int num, List<Statement> statements) {
		Loop loop = new Loop(num, statements);
		addStatement(loop);
		return this;
	}

	/**
	 * Creates and adds a loop statement to the javascript file.
	 * @param 	varName		the name of the internal variable
	 * @param 	initValue	the initial value of the variable
	 * @param 	condition	the condition to check the variable against
	 * @param 	increment	whether the variable should increment (true) or decrement (false)
	 * @param 	statements	a list of statements to be looped over
	 * @return	the JSFile object
	 */
	public JSFile createLoop(String varName, int initValue, String condition, boolean increment,
			List<Statement> statements) {
		Loop loop = new Loop(varName, initValue, condition, increment, statements);
		addStatement(loop);
		return this;
	}

	/**
	 * Creates and adds a loop statement to the javascript file.
	 * @param 	varName			the name of the internal variable
	 * @param 	collectionName	the collection to be searched
	 * @param 	statements		a list of statements to be looped over
	 * @return	the JSFile object
	 */
	public JSFile createLoop(String varName, String collectionName, List<Statement> statements) {
		Loop loop = new Loop(varName, collectionName, statements);
		addStatement(loop);
		return this;
	}

	/**
	 * Creates and adds a loop statement to the javascript file.
	 * @param 	condition	the condition to be checked
	 * @param 	statements	a list of statements to be looped over
	 * @return	the JSFile object
	 */
	public JSFile createLoop(String condition, List<Statement> statements) {
		Loop loop = new Loop(condition, statements);
		addStatement(loop);
		return this;
	}

	/**
	 * Creates and adds a custom statement to the javascript file.
	 * @param 	body	the body of the statement
	 * @return	the JSFile object
	 */
	public JSFile createCustomStatement(String body) {
		CustomStatement cs = new CustomStatement(body);
		addStatement(cs);
		return this;
	}

	/**
	 * Creates and adds a comment to the javascript file.
	 * @param 	text	the text of the comment
	 * @return	the JSFile object
	 */
	public JSFile createComment(String text) {
		Comment comment = new Comment(text);
		addStatement(comment);
		return this;
	}
}