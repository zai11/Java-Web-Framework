package com.jwf.JavaWebFramework.styling;

/**
 * An object representation of a size.
 * See <a href="../../Documentation/HTML/Styling/sizes.html">Documentation</a>
 */
public class Size {

	private float numeric;
	private String unit;
	
	/**
	 * Constructs a size using the provided parameters
	 * @param numeric the numerical value of the size
	 * @param unit the unit of the size
	 */
	public Size(int numeric, String unit) {
		this.numeric = numeric;
		this.unit = unit;
	}
	
	/**
	 * Get the numerical value of the size.
	 * @return the numerical value
	 */
	public float getNumeric() {
		return numeric;
	}
	
	/**
	 * Get the unit of the size.
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * Set the numerical value of the size to the given parameter.
	 * @param newNumeric the new numerical value
	 */
	public void setNumeric(int newNumeric) {
		numeric = newNumeric;
	}
	
	/**
	 * Set the unit of the size to the given parameter.
	 * @param newUnit the new unit.
	 */
	public void setUnit(String newUnit) {
		unit = newUnit;
	}
	
	/**
	 * Returns a string representation of a size.
	 * @return a string representation of a size.
	 */
	public String toString() {
		return numeric + unit;
	}
}
