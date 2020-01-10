package com.jwf.JavaWebFramework.misc.debugging;

/**
 * A class of custom logging functions.
 */
public class Logging {

	/**
	 * Logs an error.
	 * @param 	msg	the error message
	 */
	public static void LogError(String msg) {
		System.out.println("[!] Fatal: " + msg);
	}
	
	/**
	 * Logs a warning.
	 * @param 	msg	the warning message
	 */
	public static void LogWarning(String msg) {
		System.out.println("[?] Warning: " + msg);
	}
	
	/**
	 * Logs a comment.
	 * @param 	mgs	the comment
	 */
	public static void LogComment(String msg) {
		System.out.println("[.] Message: " + msg);
	}
}
