package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;
import com.jwf.JavaWebFramework.misc.testing.Logging;

public class Script extends Asset {

	List<Statement> statements;
	
	public Script(List<Statement> statements) {
		this.statements = statements;
	}
	
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Script...");
		String line = "";
		line += "<script>\n";
		for (Statement statement : statements) {
			//System.out.println(statement.build());
			line += "\t\t\t" + statement.build() + "\n";
		}
		line += "\t\t</script>";
		return line;
	}
}
