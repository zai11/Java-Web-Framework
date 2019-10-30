package com.jwf.JavaWebFramework.main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.jwf.JavaWebFramework.assets.CommentBuilder;
import com.jwf.JavaWebFramework.assets.HeadingBuilder;
import com.jwf.JavaWebFramework.assets.HorizontalLineBuilder;
import com.jwf.JavaWebFramework.assets.ImageBuilder;
import com.jwf.JavaWebFramework.assets.LineBreakBuilder;
import com.jwf.JavaWebFramework.assets.ParagraphBuilder;
import com.jwf.JavaWebFramework.styling.ClassBuilder;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.IDBuilder;
import com.jwf.JavaWebFramework.styling.Size;
import com.jwf.JavaWebFramework.styling.Stylesheet;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Stylesheet style = new Stylesheet("style");
		JWF.WEBSITE.addStyle(style);

		ClassBuilder classBuilder = style.addClass("heading");
		classBuilder.setColour(ClassBuilder.getColour("deep-sky-blue")).setFont("Courier", new Size(40, "px"), 300)
				.setTextAlign("Center");

		IDBuilder idBuilder = style.addID("paragraph");
		idBuilder.setFontSize(new Size(32, "px")).setColour(ClassBuilder.getColour("blue"));

		Page page = new Page("first-page");
		JWF.WEBSITE.addPage(page);
		page.setTitle("Home");
		page.addStyle(style);

		HeadingBuilder hb = new HeadingBuilder();
		hb.setSize(1).setText("Test Heading").addClass(classBuilder.buildClass());
		page.add(hb.build());

		CommentBuilder cb = new CommentBuilder();
		cb.setText("This is a test comment.");
		page.add(cb.build());

		LineBreakBuilder lbb = new LineBreakBuilder();
		page.add(lbb.build());

		ParagraphBuilder pb = new ParagraphBuilder();
		pb.setText("Test Paragraph").setID(idBuilder.buildID());
		page.add(pb.build());

		HorizontalLineBuilder hlb = new HorizontalLineBuilder();
		page.add(hlb.build());

		ImageBuilder ib = new ImageBuilder();
		ib.setSource("img1.jpg");
		page.add(ib.build());

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				pb.setText(Integer.toString(i)).setID(ID.NULL);
				page.add(pb.build());
			}
		}
		JWF.build();
	}
}
