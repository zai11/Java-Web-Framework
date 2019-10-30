package com.jwf.JavaWebFramework.main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.jwf.JavaWebFramework.misc.ConfigParser;
import com.jwf.JavaWebFramework.styling.StyleBuilder;

public class JWF {

	public static final Website WEBSITE = new Website();
	
	public static void build() throws FileNotFoundException, UnsupportedEncodingException {
		ConfigParser cp = new ConfigParser(WEBSITE, "website.conf");
		cp.parse();
		PageBuilder pb = new PageBuilder(WEBSITE);
		pb.build();
		if (SiteConfig.ENABLE_CSS) {
			StyleBuilder sb = new StyleBuilder(WEBSITE);
			sb.build();
		}
	}
}
