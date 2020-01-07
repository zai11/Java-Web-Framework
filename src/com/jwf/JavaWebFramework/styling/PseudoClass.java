package com.jwf.JavaWebFramework.styling;

import com.jwf.JavaWebFramework.misc.collections.PseudoClasses;

public class PseudoClass {

	private PseudoClasses type;
	private String value;
	private String body;
	
	public PseudoClass(PseudoClasses type) {
		this.type = type;
	}
	
	public PseudoClass(PseudoClasses type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public void changeType(PseudoClasses type) {
		this.type = type;
	}
	
	public void changeValue(String value) {
		this.value = value;
	}
	
	public String build() {
		this.body = ":" + this.type.toString().toLowerCase();
		if (this.value != null && !this.value.isEmpty()) {
			this.body += "(" + this.value + ")";
		}
		return this.body;
	}
}
