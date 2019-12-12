package com.jwf.JavaWebFramework.misc.debugging;

public class Debug {

	public static boolean testType(Object variable, Class<?> testClass) {
		return testClass.isInstance(variable);
	}
	
	public static boolean testType(Object variable, Class<?> testClass, String msg) {
		if (testClass.isInstance(variable)) {
			System.out.println(msg);
			return true;
		}
		return false;
	}
	
	public static boolean testValue(Object var1, Object var2) {
		return (var1 == var2);
	}
	
	public static boolean testValue(Object var1, Object var2, String msg) {
		if (var1 == var2) {
			System.out.println(msg);
			return true;
		}
		return false;
	}
}
