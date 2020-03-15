package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 * A Paragraph Builder - All attributes are set and then the final table is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/tables.html#TableBuilder">Documentation</a>
 * @see Asset
 * @see Table
 */
public class TableBuilder extends Builder<Table> {

	List<String> headers = new ArrayList<String>();
	List<TableRow> rows = new ArrayList<TableRow>();
	String align;
	String bgColour;
	boolean border;
	int cellPadding = -1;
	int cellSpacing = -1;
	String frame;
	String rules;
	String summary;
	int width = -1;
	
	/**
	 * Adds a header to the table.
	 * @param 	header	the header to be added
	 * @return	the TableBuilder object
	 */
	public TableBuilder addHeader(String header) {
		this.headers.add(header);
		return this;
	}
	
	/**
	 * Removes the most recent header with the specified name.
	 * @param 	header	the header to be removed
	 * @return	the TableBuilder object
	 */
	public TableBuilder removeHeader(String header) {
		for (String h : this.headers) {
			if (h.equals(header)) {
				this.headers.remove(h);
				return this;
			}
		}
		Logging.LogError("Unable to find header: " + header);
		return this;
	}
	
	/**
	 * Clears the table's headers.
	 * @return	the TableBuilder object
	 */
	public TableBuilder clearHeaders() {
		this.headers.clear();
		return this;
	}
	
	/**
	 * Adds a row to the table.
	 * @param 	tr	the row to be added
	 * @return	the TableBuilder object
	 */
	public TableBuilder addRow(TableRow tr) {
		this.rows.add(tr);
		return this;
	}
	
	/**
	 * Adds a row to the table with the specified cells.
	 * @param 	cells	the cells of the row to be added
	 * @return	the TableBuilder object
	 */
	public TableBuilder addRow(String... cells) {
		this.rows.add(new TableRow(this, cells));
		return this;
	}
	
	/**
	 * Removes the provided row from the table.
	 * @param 	tr	the row to be removed
	 * @return	the TableBuilder object
	 */
	public TableBuilder removeRow(TableRow tr) {
		for (TableRow row : this.rows) {
			if (row.equals(tr)) {
				this.rows.remove(tr);
				return this;
			}
		}
		Logging.LogError("Unable to find the table row: " + tr);
		return this;
	}
	
	/**
	 * Clears the table's rows.
	 * @return	the TableBuilder object
	 */
	public TableBuilder clearRows() {
		this.rows.clear();
		return this;
	}
	
	/**
	 * Sets the alignment of the table.
	 * @param 	align	the alignment of the table
	 * @return	the TableBuilder object
	 */
	public TableBuilder setAlign(String align) {
		this.align = align;
		return this;
	}
	
	/**
	 * Sets the background colour of the table.
	 * @param 	bgColour	the background colour
	 * @return	the TableBuilder object
	 */
	public TableBuilder setBackgroundColour(String bgColour) {
		this.bgColour = bgColour;
		return this;
	}
	
	/**
	 * Sets whether the table is being used for layout purposes or not.
	 * @param 	border 	whether the table is being used for layout purposes or not
	 * @return	the TableBuilder object
	 */
	public TableBuilder setBorder(boolean border) {
		this.border = border;
		return this;
	}
	
	/**
	 * Sets the padding of the cells in the table.
	 * @param 	cellPadding	the padding of the cells
	 * @return	the TableBuilder object
	 */
	public TableBuilder setCellPadding(int cellPadding) {
		this.cellPadding = cellPadding;
		return this;
	}
	
	/**
	 * Sets the spacing between the cells in the table.
	 * @param 	cellSpacing	the spacing between the cells
	 * @return	the TableBuilder object
	 */
	public TableBuilder setCellSpacing(int cellSpacing) {
		this.cellSpacing = cellSpacing;
		return this;
	}
	
	/**
	 * Sets the parts of the outside borders that should be visible.
	 * @param 	frame	the parts of the outside borders that should be visible
	 * @return	the TableBuilder object
	 */
	public TableBuilder setFrame(String frame) {
		this.frame = frame;
		return this;
	}
	
	/**
	 * Sets the parts of the inside borders that should be visible
	 * @param 	rules	the parts of the inside borders that should be visible
	 * @return	the TableBuilder object
	 */
	public TableBuilder setRules(String rules) {
		this.rules = rules;
		return this;
	}
	
	/**
	 * Sets the summary of the table.
	 * @param 	summary	a summary of the table's contents
	 * @return	the TableBuilder object
	 */
	public TableBuilder setSummary(String summary) {
		this.summary = summary;
		return this;
	}
	
	/**
	 * Sets the width of the table.
	 * @param 	width	the width of the table
	 * @return	the TableBuilder object
	 */
	public TableBuilder setWidth(int width) {
		this.width = width;
		return this;
	}
	
	/**
	 * Builds the table.
	 * @return	the constructed table
	 */
	@Override
	public Asset build() {
		return new Table(headers, rows, align, bgColour, border, cellPadding, cellSpacing, frame, rules, summary, width);
	}
}
