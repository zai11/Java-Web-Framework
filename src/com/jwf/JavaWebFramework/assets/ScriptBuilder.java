package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.js.builder.PrimitiveVariable;
import com.jwf.JavaWebFramework.js.builder.Statement;
import com.jwf.JavaWebFramework.js.builder.statements.Assignment;
import com.jwf.JavaWebFramework.js.builder.statements.Conditional;
import com.jwf.JavaWebFramework.js.builder.statements.CustomStatement;
import com.jwf.JavaWebFramework.js.builder.statements.FunctionCall;
import com.jwf.JavaWebFramework.js.builder.statements.FunctionDeclaration;
import com.jwf.JavaWebFramework.js.builder.statements.Loop;
import com.jwf.JavaWebFramework.js.builder.statements.VariableDeclaration;
import com.jwf.JavaWebFramework.js.builder.statements.Comment;
import com.jwf.JavaWebFramework.misc.testing.Logging;
import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

public class ScriptBuilder extends Builder<Script> {

	private List<Statement> statements = new ArrayList<>();
	private List<PrimitiveVariable<?>> variables = new ArrayList<>();
	
	public ScriptBuilder() {}
	
	public ScriptBuilder addStatement(Statement statement) {
		this.statements.add(statement);
		return this;
	}
	
	public List<Statement> getStatements() {
		return statements;
	}
	
	public ScriptBuilder addVariable(PrimitiveVariable<?> var) {
		this.variables.add(var);
		return this;
	}
	
	public List<PrimitiveVariable<?>> getVariables() {
		return this.variables;
	}
	
	public PrimitiveVariable<?> findVariable(String varName) {
		for (PrimitiveVariable<?> var : variables) {
			if (var.getName().equals(varName)) {
				return var;
			}
		}
		Logging.LogError("Unable to find variable: " + varName);
		return null;
	}
	
	public boolean checkForVariable(String varName) {
		for (PrimitiveVariable<?> var : variables) {
			if (var.getName().equals(varName)) {
				return true;
			}
		}
		return false;
	}
	
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
	
	public ScriptBuilder createVariableDeclaration(String name, Object value) {
		VariableDeclaration vardec = new VariableDeclaration(name, value);
		addStatement(vardec);
		PrimitiveVariable<Object> var = new PrimitiveVariable<>(name, value);
		addVariable(var);
		return this;
	}
	
	public ScriptBuilder createAssignment(String varName, Object value) {
		Assignment<Object> assignment = new Assignment<>(varName, value);
		addStatement(assignment);
		@SuppressWarnings("unchecked")
		PrimitiveVariable<Object> var = (PrimitiveVariable<Object>) findVariable(varName);
		var.setValue(value);
		return this;
	}
	
	public ScriptBuilder createFunctionCall(String funcName) {
		FunctionCall funcCall = new FunctionCall(funcName);
		addStatement(funcCall);
		return this;
	}
	
	public ScriptBuilder createFunctionDeclaration(String funcName, String... params) {
		FunctionDeclaration funcDec = new FunctionDeclaration(funcName, params);
		addStatement(funcDec);
		return this;
	}
	
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
	
	public ScriptBuilder createConditional(String condition, List<Statement> trueStatements) {
		Conditional conditional = new Conditional(condition, trueStatements, this);
		addStatement(conditional);
		return this;
	}
	
	public ScriptBuilder createConditional(String condition, List<Statement> trueStatements, List<Statement> falseStatements) {
		Conditional conditional = new Conditional(condition, trueStatements, falseStatements, this);
		addStatement(conditional);
		return this;
	}
	
	public ScriptBuilder createLoop(int num, List<Statement> statements) {
		Loop loop = new Loop(num, statements);
		addStatement(loop);
		return this;
	}
	
	public ScriptBuilder createCustomStatement(String body) {
		CustomStatement cs = new CustomStatement(body);
		addStatement(cs);
		return this;
	}
	
	public ScriptBuilder createComment(String text) {
		Comment comment = new Comment(text);
		addStatement(comment);
		return this;
	}
	
	@Override
	public Asset build() {
		return new Script(statements);
	}

	@Override
	public Class buildClass() {
		return null;
	}

	@Override
	public ID buildID() {
		return null;
	}

}
