package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A table - equivalent to the HTML {@code <table>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/tables.html">Documentation</a>
 * @see Asset
 */
public class Table extends Asset {

	List<String> headers;
	List<TableRow> rows;
	String align;
	String bgColour;
	boolean border;
	int cellPadding;
	int cellSpacing;
	String frame;
	String rules;
	String summary;
	int width;

	/**
	 * Constructs a table using the provided parameters.
	 * @param headers		a list of the table headers
	 * @param rows			a list of the table rows
	 * @param align			the alignment of the table
	 * @param bgColour		the background colour of the table
	 * @param border		whether the table is being used for layout purposes or not
	 * @param cellPadding	the padding of the cells
	 * @param cellSpacing	the spacing between the cells
	 * @param frame			the parts of the outside borders that should be visible
	 * @param rules			the parts of the inside borders that should be visible
	 * @param summary		a summary of the table's contents
	 * @param width			the width of the table
	 */
	public Table(List<String> headers, List<TableRow> rows, String align, String bgColour, boolean border,
			int cellPadding, int cellSpacing, String frame, String rules, String summary, int width) {
		this.assetType = Assets.TABLE;
		this.headers = headers;
		this.rows = rows;
		this.align = align;
		this.bgColour = bgColour;
		this.border = border;
		this.cellPadding = cellPadding;
		this.cellSpacing = cellSpacing;
		this.frame = frame;
		this.rules = rules;
		this.summary = summary;
		this.width = width;
	}

	/**
	 * Builds the HTML line for the table based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		Logging.LogComment("Creating Table...");
		String line = "<table";
		if (this.align != null && !this.align.isEmpty())
			line += " align=\"" + this.align + "\"";
		if (this.bgColour != null && !this.bgColour.isEmpty())
			line += " bgcolor=\"" + this.bgColour + "\"";
		if (this.border)
			line += " border=\"1\"";
		if (this.cellPadding != -1)
			line += " cellpadding=\"" + this.cellPadding + "\"";
		if (this.cellSpacing != -1)
			line += " cellSpacing=\"" + this.cellSpacing + "\"";
		if (this.frame != null && !this.frame.isEmpty())
			line += " frame=\"" + this.frame + "\"";
		if (this.rules != null && !this.rules.isEmpty())
			line += " rules=\"" + this.rules + "\"";
		if (this.summary != null && !this.summary.isEmpty())
			line += " summary=\"" + this.summary + "\"";
		if (this.width != -1)
			line += " width=\"" + this.width + "\"";
		line += ">\n";
		line += "\t\t\t<tr>\n";
		for (String header : this.headers) {
			line += "\t\t\t\t<th>" + header + "</th>\n";
		}
		line += "\t\t\t</tr>\n";
		for (TableRow tr : this.rows) {
			line += "\t\t\t<tr>\n";
			for (String cell : tr.cells) {
				line += "\t\t\t\t<td>" + cell + "</td>\n";
			}
			line += "\t\t\t</tr>\n";
		}
		line += "\t\t</table>";
		return line;
	}
}