package com.jwf.JavaWebFramework.assets;

import java.util.ArrayList;
import java.util.List;

import com.jwf.JavaWebFramework.misc.debugging.Logging;

/**
 *	An object representation of a Table Row.
 */
public class TableRow {

	List<String> cells = new ArrayList<String>();
	TableBuilder parent;
	int id;
	
	/**
	 * Constructs a Table Row using the provided parameters.
	 * @param parent	the parent table
	 */
	public TableRow(TableBuilder parent) {
		this.parent = parent;
		this.id = parent.rows.size();
	}
	
	/**
	 * Constructs a Table Row using the provided parameters.
	 * @param parent	the parent table
	 * @param cells		any cells to be added to the row
	 */
	public TableRow(TableBuilder parent, String... cells) {
		this.parent = parent;
		this.id = parent.rows.size();
		for (String cell : cells) {
			this.cells.add(cell);
		}
	}
	
	/**
	 * Adds a cell to the table row.
	 * @param cell	the content of the cell to be added
	 */
	public void addCell(String cell) {
		this.cells.add(cell);
	}
	
	/**
	 * Removes the most recent cell with the specified content.
	 * @param cell	the content of the cell to be removed
	 */
	public void removeCell(String cell) {
		for (String c : this.cells) {
			if (c.equals(cell)) {
				this.cells.remove(c);
				return;
			}
		}
		Logging.LogError("Unable to find cell: " + cell + " in table row: " + this.id);
	}
	
	/**
	 * Returns a textual representation of the table row.
	 * @return	the textual representation
	 */
	@Override
	public String toString() {
		String value = "{ ";
		for (int i = 0; i < cells.size(); i++) {
			value += cells.get(i) + ", ";
		}
		value += cells.get(cells.size());
		value += " }";
		return value;
	}
}