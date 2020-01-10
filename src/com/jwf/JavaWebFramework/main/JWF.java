package com.jwf.JavaWebFramework.main;

import com.jwf.JavaWebFramework.js.builder.JSFileBuilder;
import com.jwf.JavaWebFramework.misc.ConfigParser;
import com.jwf.JavaWebFramework.styling.StyleBuilder;

/**
 * The main class.
 */
public class JWF {

	public static final Website WEBSITE = new Website();
	
	/**
	 * Builds the entire website.
	 */
	public static void build() {
		ConfigParser cp = new ConfigParser(WEBSITE, "website.conf");
		cp.parse();
		PageBuilder pb = new PageBuilder(WEBSITE);
		pb.build();
		if (SiteConfig.ENABLE_CSS) {
			StyleBuilder sb = new StyleBuilder(WEBSITE);
			sb.build();
		}
		if (SiteConfig.ENABLE_JS) {
			JSFileBuilder jsBuilder = new JSFileBuilder();
			jsBuilder.build();
		}
	}
}
