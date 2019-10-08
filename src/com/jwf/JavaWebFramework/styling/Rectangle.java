package com.jwf.JavaWebFramework.styling;

public class Rectangle {

	float p1, p2, p3, p4;
	
	public Rectangle(float p1, float p2, float p3, float p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	public String toString() {
		return "Rect(" + p1 + ", " + p2 + ", " + p3 + ", " + p4 + ")";
	}
}
