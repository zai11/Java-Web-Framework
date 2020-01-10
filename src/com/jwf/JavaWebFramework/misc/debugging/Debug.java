package com.jwf.JavaWebFramework.misc.debugging;

/**
 * Functions for debugging purposes.
 */
public class Debug {

	/**
	 * Tests if a variable is of a certain type.
	 * @param 	variable	the variable to test
	 * @param 	testType	the type
	 * @return 	whether the variable is of a certain type (true) or not (false)
	 */
	public static boolean testType(Object variable, Class<?> testType) {
		return testType.isInstance(variable);
	}
	
	/**
	 * Tests if a variable is of a certain type and prints a message.
	 * @param 	variable	the variable to test
	 * @param 	testType	the type
	 * @param 	msg			the message to output
	 * @return	whether the variable is of a certain type (true) or not (false)
	 */
	public static boolean testType(Object variable, Class<?> testType, String msg) {
		if (testType.isInstance(variable)) {
			System.out.println(msg);
			return true;
		}
		return false;
	}
	
	/**
	 * Tests if a variable is equal to another variable.
	 * @param 	var1	the first variable
	 * @param 	var2	the second variable
	 * @return	whether the variables are equal (true) or not (false)
	 */
	public static boolean testValue(Object var1, Object var2) {
		return (var1 == var2);
	}
	
	/**
	 * Tests if a variable is equal to another variable and prints a message.
	 * @param 	var1	the first variable
	 * @param 	var2	the second variable
	 * @param 	msg		the mesage to output
	 * @return	whether the variable is of a certain type (true) or not (false)
	 */
	public static boolean testValue(Object var1, Object var2, String msg) {
		if (var1 == var2) {
			System.out.println(msg);
			return true;
		}
		return false;
	}
}
