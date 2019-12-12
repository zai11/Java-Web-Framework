package com.jwf.JavaWebFramework.misc.debugging;

public class Logging {

	public static void LogError(String msg) {
		System.out.println("[!] Fatal: " + msg);
	}
	
	public static void LogWarning(String msg) {
		System.out.println("[?] Warning: " + msg);
	}
	
	public static void LogComment(String msg) {
		System.out.println("[.] Message: " + msg);
	}
}
