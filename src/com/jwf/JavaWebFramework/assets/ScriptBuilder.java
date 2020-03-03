package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.assets.form.Form;
import com.jwf.JavaWebFramework.js.builder.PrimitiveVariable;
import com.jwf.JavaWebFramework.js.builder.Statement;
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
 * A Script Builder - All attributes are set and then the final script is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/scripts.html#ScriptBuilder">Documentation</a>
 * @see Scripts
 * @see Asset
 * @see Form
 */
public class ScriptBuilder extends Builder<Script> {

	private List<Statement> statements = new ArrayList<>();
	private List<PrimitiveVariable<?>> variables = new ArrayList<>();
	
	/**
	 * Adds a statement to the script.
	 * @param 	statement	the statement to be added
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder addStatement(Statement statement) {
		this.statements.add(statement);
		return this;
	}
	
	/**
	 * Gets a list of statements.
	 * @return	the list of statements
	 */
	public List<Statement> getStatements() {
		return statements;
	}
	
	/**
	 * Adds a variable to the script.
	 * @param 	var	the variable to be added
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder addVariable(PrimitiveVariable<?> var) {
		this.variables.add(var);
		return this;
	}
	
	/**
	 * Returns a list of all of the variables in the script.
	 * @return	the list of variables
	 */
	public List<PrimitiveVariable<?>> getVariables() {
		return this.variables;
	}
	
	/**
	 * Search through the variables and return the one that
	 * matches the name provided.
	 * @param 	varName	the variable name to search for
	 * @return	the found variable
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
	 * Check if a variable with the provided name exists.
	 * @param 	varName	the name of the variable to check for
	 * @return	if the variable exists
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
	 * Updates the value of a given variable.
	 * @param 	varName		the name of the variable to update
	 * @param 	newValue	the new value of the variable
	 * @return	whether the variable was successfully updates (true) or not (false)
	 */
	public boolean updateVariableValue(String varName, Object newValue) {
		for (PrimitiveVariable<?> var : variables) {
			if (var.getName().equals(varName)) {
				var.setValue(newValue);
				return true;
			}
		}
		Logging.LogError("Unable to find variable: " + varName);
		return false;
	}
	
	/**
	 * Creates and adds a variable declaration statement to the script.
	 * @param 	name	the name of the variable
	 * @param 	value	the value of the variable
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createVariableDeclaration(String name, Object value) {
		VariableDeclaration vardec = new VariableDeclaration(name, value);
		addStatement(vardec);
		PrimitiveVariable<Object> var = new PrimitiveVariable<>(name, value);
		addVariable(var);
		return this;
	}
	
	/**
	 * Creates and adds an assignment statement to the script.
	 * @param 	varName	the name of the variable
	 * @param 	value	the value of the variable
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createAssignment(String varName, Object value) {
		Assignment<Object> assignment = new Assignment<>(varName, value);
		addStatement(assignment);
		@SuppressWarnings("unchecked")
		PrimitiveVariable<Object> var = (PrimitiveVariable<Object>) findVariable(varName);
		var.setValue(value);
		return this;
	}
	
	/**
	 * Creates and adds a function call statement to the script. 
	 * @param 	funcName	the name of the function to call
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createFunctionCall(String funcName) {
		FunctionCall funcCall = new FunctionCall(funcName);
		addStatement(funcCall);
		return this;
	}
	
	/**
	 * Creates and adds a function declaration statement to the script.
	 * @param 	funcName	the name of the function
	 * @param 	params		the names of the parameters
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createFunctionDeclaration(String funcName, String... params) {
		FunctionDeclaration funcDec = new FunctionDeclaration(funcName, params);
		addStatement(funcDec);
		return this;
	}
	
	/**
	 * Finds a specific function with the provided name.
	 * @param 	funcName	the name of the function to find
	 * @return	the ScriptBuilder object
	 */
	public FunctionDeclaration getFunction(String funcName) {
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
	 * Creates and adds a conditional statement to the script.
	 * @param 	condition		the condition to be checked
	 * @param 	trueStatements	a list of statements to be executed if the condition is true
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createConditional(String condition, List<Statement> trueStatements) {
		Conditional conditional = new Conditional(condition, trueStatements, this);
		addStatement(conditional);
		return this;
	}
	
	/**
	 * Creates and adds a conditional statement to the script.
	 * @param 	condition		the condition to be checked
	 * @param 	trueStatements	a list of statements to be executed if the condition is true
	 * @param 	falseStatements	a list of statements to be executed if the condition is false
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createConditional(String condition, List<Statement> trueStatements, List<Statement> falseStatements) {
		Conditional conditional = new Conditional(condition, trueStatements, falseStatements, this);
		addStatement(conditional);
		return this;
	}
	
	/**
	 * Creates and adds a loop statement to the script.
	 * @param 	num			the number of times the loop will run
	 * @param 	statements	a list of statements to be looped over
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createLoop(int num, List<Statement> statements) {
		Loop loop = new Loop(num, statements);
		addStatement(loop);
		return this;
	}

	/**
	 * Creates and adds a loop statement to the script.
	 * @param 	varName		the name of the internal variable
	 * @param 	initValue	the initial value of the variable
	 * @param 	condition	the condition to check the variable against
	 * @param 	increment	whether the variable should increment (true) or decrement (false)
	 * @param 	statements	a list of statements to be looped over
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createLoop(String varName, int initValue, String condition, boolean increment, List<Statement> statements) {
		Loop loop = new Loop(varName, initValue, condition, increment, statements);
		addStatement(loop);
		return this;
	}
	
	/**
	 * Creates and adds a loop statement to the script.
	 * @param 	varName			the name of the internal variable
	 * @param 	collectionName	the name of the collection variable to search through
	 * @param 	statements		a list of statements to be looped over
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createLoop(String varName, String collectionName, List<Statement> statements) {
		Loop loop = new Loop(varName, collectionName, statements);
		addStatement(loop);
		return this;
	}
	
	/**
	 * Creates and adds a loop statement to the script.
	 * @param 	condition	the condition to be checked
	 * @param 	statements	a list of statements to be looped over
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createLoop(String condition, List<Statement> statements) {
		Loop loop = new Loop(condition, statements);
		addStatement(loop);
		return this;
	}
	
	/**
	 * Creates and adds a custom statement to the script.
	 * @param 	body	the body of the statement
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createCustomStatement(String body) {
		CustomStatement cs = new CustomStatement(body);
		addStatement(cs);
		return this;
	}
	
	/**
	 * Creates and adds a comment to the script.
	 * @param 	text	the text in the comment
	 * @return	the ScriptBuilder object
	 */
	public ScriptBuilder createComment(String text) {
		Comment comment = new Comment(text);
		addStatement(comment);
		return this;
	}
	
	/**
	 * Builds the script.
	 * @return	the constructed script
	 */
	@Override
	public Asset build() {
		return new Script(statements);
	}
}
