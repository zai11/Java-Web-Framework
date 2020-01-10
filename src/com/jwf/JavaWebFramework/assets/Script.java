package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.js.builder.Statement;
import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A script - equivalent to the HTML {@code <script></script>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/scripts.html">Documentation</a>
 * @see Asset
 */
public class Script extends Asset {

	List<Statement> statements;
	
	/**
	 * Constructs a script using the given parameters.
	 * @param 	statements	the JS statements to be put in the script
	 */
	public Script(List<Statement> statements) {
		this.assetType = Assets.SCRIPT;
		this.statements = statements;
	}
	
	/**
	 * Builds the HTML lines based on the set variables.
	 * @return	the HTML lines
	 */
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
