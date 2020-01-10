package com.jwf.JavaWebFramework.styling;

/**
 * An object representation of a rectangle.
 * Used in CSS
 */
public class Rectangle {

	float p1, p2, p3, p4;
	
	/**
	 * Constructs a rectangle using the provided parameters.
	 * @param 	p1	the first point
	 * @param 	p2	the second point
	 * @param 	p3	the third point
	 * @param 	p4	the fourth point
	 */
	public Rectangle(float p1, float p2, float p3, float p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	/**
	 * Returns a string representation of a rectangle.
	 * @return	the string representation of a rectangle
	 */
	public String toString() {
		return "Rect(" + p1 + ", " + p2 + ", " + p3 + ", " + p4 + ")";
	}
}
