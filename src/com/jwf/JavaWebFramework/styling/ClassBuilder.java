package com.jwf.JavaWebFramework.styling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jwf.JavaWebFramework.assets.Asset;
import com.jwf.JavaWebFramework.assets.Builder;

public class ClassBuilder extends Builder<Class> {

	private String name;
	private List<Attribute> attributes = new ArrayList<Attribute>();

	/**
	 * Constructs a class using the given parameter.
	 * @param name the name of the class
	 */
	public ClassBuilder(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the class.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a list of the current attributes attached to this class.
	 * @return a list of attributes
	 */
	public List<Attribute> getAttribs() {
		setName("Test");
		return attributes;
	}

	/**
	 * Sets the name of the class to the given parameter.
	 * @param newName the new name
	 */
	public ClassBuilder setName(String newName) {
		this.name = newName;
		return this;
	}

	/**
	 * Adds a CSS attribute to the class.
	 * @param key the first part of the attribute (e.g. "color")
	 * @param value the second part of the attribute (e.g. "#FFFFFF")
	 */
	public void addAttrib(String key, String value) {
		Attribute a = new Attribute(key, value);
		this.attributes.add(a);
	}

	/**
	 * Reads the styling.xml file to find the value that corresponds to the given colour.
	 * @param key the colour to search for (e.g. "red")
	 * @return the value of the colour (e.g. "#FF0000");
	 */
	public static String getColour(String key) {
		String value = "";
		Map<String, String> colours = ReadXML("colour");
		if (colours.containsKey(key.toLowerCase())) {
			value = colours.get(key.toLowerCase());
			return value;
		}
		System.err.println("Error: Unable to find the colour " + key);
		return null;
	}
	
	/**
	 * Sets the colour of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/colour.html">Documentation</a>
	 * @param colour the new colour
	 */
	public ClassBuilder setColour(String colour) {
		addAttrib("color", colour);
		return this;
	}
	
	/**
	 * Sets the background colour of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_colour.html">Documentation</a>
	 * @param colour the new colour
	 */
	public ClassBuilder setBackgroundColour(String colour) {
		addAttrib("background-color", colour);
		return this;
	}
	
	/**
	 * Sets the background image of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_image.html">Documentation</a>
	 * @param image the location of the image
	 */
	public ClassBuilder setBackgroundImage(String image) {
		addAttrib("background-repeat", image);
		return this;
	}
	
	/**
	 * Sets if/how the background image will repeat.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_repeat.html">Documentation</a>
	 * @param value if/how the background image will repeat
	 */
	public ClassBuilder setBackgroundRepeat(String value) {
		addAttrib("background-repeat", value);
		return this;
	}
	
	/**
	 * Sets whether the background image will scroll with
	 * the rest of the page or remain fixed.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_attachment.html">Documentation</a>
	 * @param value the background attachment value
	 */
	public ClassBuilder setBackgroundAttachment(String value) {
		addAttrib("background-attachment", value);
		return this;
	}
	
	/**
	 * Specifies how far the background should extend within an element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_clip.html">Documentation</a>
	 * @param value the background clip value
	 */
	public ClassBuilder setBackgroundClip(String value) {
		addAttrib("background-clip", value);
		return this;
	}
	
	/**
	 * Sets the position of the background.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_position.html">Documentation</a>
	 * @param position the new position of the background
	 */
	public ClassBuilder setBackgroundPosition(String position) {
		addAttrib("background-position", position);
		return this;
	}
	
	/**
	 * Sets the origin position of the background image.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_origin.html">Documentation</a>
	 * @param origin the new origin position
	 */
	public ClassBuilder setBackgroundOrigin(String origin) {
		addAttrib("background-origin", origin);
		return this;
	}
	
	/**
	 * Sets the background size of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_size.html">Documentation</a>
	 * @param size the new size
	 */
	public ClassBuilder setBackgroundSize(Size size) {
		addAttrib("background-size", size.toString());
		return this;
	}
	
	/**
	 * Sets the background size of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Background/background_size.html">Documentation</a>
	 * @param width the new width
	 * @param height the new height
	 */
	public ClassBuilder setBackgroundSize(Size width, Size height) {
		addAttrib("background-size", width.toString() + ' ' + height.toString());
		return this;
	}
	
	/**
	 * Changes the font of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Font/font.html">Documentation</a>
	 * @param family the font family
	 * @param size the font size
	 * @param weight the font weight
	 */
	public ClassBuilder setFont(String family, Size size, int weight) {
		addAttrib("font-family", family);
		addAttrib("font-size", size.toString());
		addAttrib("font-weight", Integer.toString(weight));
		return this;
	}
	
	/**
	 * Changes the font family of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Font/font_family.html">Documentation</a>
	 * @param family the font family
	 */
	public ClassBuilder setFontFamily(String family) {
		addAttrib("font-family", family);
		return this;
	}
	
	/**
	 * Changes the font size of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Font/font_size.html">Documentation</a>
	 * @param size the font size
	 */
	public ClassBuilder setFontSize(Size size) {
		addAttrib("font-size", size.toString());
		return this;
	}
	
	/**
	 * Changes the font style of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Font/font_style.html">Documentation</a>
	 * @param style the font style
	 */
	public ClassBuilder setFontStyle(String style) {
		addAttrib("font-style", style);
		return this;
	}
	
	/**
	 * Specifies whether or not the text will be displayed
	 * in small-caps.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Font/font_variant.html">Documentation</a>
	 * @param variant the font variant value
	 */
	public ClassBuilder setFontVariant(String variant) {
		addAttrib("font-variant", variant);
		return this;
	}
	
	/**
	 * Specifies the weight of the font.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Font/font_weight.html">Documentation</a>
	 * @param weight the font weight
	 */
	public ClassBuilder setFontWeight(int weight) {
		addAttrib("font-weight", Integer.toString(weight));
		return this;
	}
	
	/**
	 * Sets the width of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Dimensions/width.html">Documentation</a>
	 * @param width the new width
	 */
	public ClassBuilder setWidth(Size width) {
		addAttrib("width", width.toString());
		return this;
	}
	
	/**
	 * Sets the maximum width of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Dimensions/max_width.html">Documentation</a>
	 * @param width the maximum width
	 */
	public ClassBuilder setMaxWidth(Size width) {
		addAttrib("max-width", width.toString());
		return this;
	}
	
	/**
	 * Sets the minimum width of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Dimensions/min_width.html">Documentation</a>
	 * @param width the minimum width
	 */
	public ClassBuilder setMinWidth(Size width) {
		addAttrib("min-width", width.toString());
		return this;
	}
	
	/**
	 * Sets the height of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Dimensions/height.html">Documentation</a>
	 * @param height the new height
	 */
	public ClassBuilder setHeight(Size height) {
		addAttrib("height", height.toString());
		return this;
	}
	
	/**
	 * Sets the maximum height of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Dimensions/max_height.html">Documentation</a>
	 * @param height the maximum height
	 */
	public ClassBuilder setMaxHeight(Size height) {
		addAttrib("max-height", height.toString());
		return this;
	}
	
	/**
	 * Sets the minimum height of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Dimensions/min_height.html">Documentation</a>
	 * @param height the minimum height
	 */
	public ClassBuilder setMinHeight(Size height) {
		addAttrib("min-height", height.toString());
		return this;
	}
	
	/**
	 * Changes the padding values for the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/padding.html">Documentation</a>
	 * @param left the left padding
	 * @param right the right padding 
	 * @param top the top padding
	 * @param bottom the bottom padding
	 */
	public ClassBuilder setPadding(Size left, Size right, Size top, Size bottom) {
		addAttrib("padding", left.toString() + ' ' + right.toString() + ' ' + top.toString() + ' ' + bottom.toString());
		return this;
	}
	
	/**
	 * Sets the x and y padding values for the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/padding.html">Documentation</a>
	 * @param x the x padding value
	 * @param y the y padding value
	 */
	public ClassBuilder setPadding(Size x, Size y) {
		addAttrib("padding", x.toString() + ' ' + y.toString());
		return this;
	}
	
	/**
	 * Sets the padding values for the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/padding.html">Documentation</a>
	 * @param padding the padding value
	 */
	public ClassBuilder setPadding(Size padding) {
		addAttrib("padding", padding.toString());
		return this;
	}
	
	/**
	 * Sets the left padding value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/left_padding.html">Documentation</a>
	 * @param padding the left padding value
	 */
	public ClassBuilder setPaddingLeft(Size padding) {
		addAttrib("padding-left", padding.toString());
		return this;
	}
	
	/**
	 * Sets the right padding value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/right_padding.html">Documentation</a>
	 * @param padding the right padding value
	 */
	public ClassBuilder setPaddingRight(Size padding) {
		addAttrib("padding-right", padding.toString());
		return this;
	}
	
	/**
	 * Sets the top padding value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/top_padding.html">Documentation</a>
	 * @param padding the top padding value
	 */
	public ClassBuilder setPaddingTop(Size padding) {
		addAttrib("padding-top", padding.toString());
		return this;
	}
	
	/**
	 * Sets the bottom padding value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Padding/bottom_padding.html">Documentation</a>
	 * @param padding the bottom padding value
	 */
	public ClassBuilder setPaddingBottom(Size padding) {
		addAttrib("padding-bottom", padding.toString());
		return this;
	}
	
	/**
	 * Sets the margin values of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/margin.html">Documentation</a>
	 * @param left   the left margin value
	 * @param right  the right margin value
	 * @param top    the top margin value
	 * @param bottom the bottom margin value
	 */
	public ClassBuilder setMargin(Size left, Size right, Size top, Size bottom) {
		addAttrib("margin", left.toString() + ' ' + right.toString() + ' ' + top.toString() + ' ' + bottom.toString());
		return this;
	}
	
	/**
	 * Sets the x and y margin values of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/margin.html">Documentation</a>
	 * @param x the x margin value
	 * @param y the y margin value
	 */
	public ClassBuilder setMargin(Size x, Size y) {
		addAttrib("margin", x.toString() + ' ' + y.toString());
		return this;
	}
	
	/**
	 * Sets the margin values of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/margin.html">Documentation</a>
	 * @param margin the margin value
	 */
	public ClassBuilder setMargin(Size margin) {
		addAttrib("margin", margin.toString());
		return this;
	}
	
	/**
	 * Sets the left margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/left_margin.html">Documentation</a>
	 * @param margin the left margin value
	 */
	public ClassBuilder setMarginLeft(Size margin) {
		addAttrib("margin-left", margin.toString());
		return this;
	}
	
	/**
	 * Sets the right margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/right_margin.html">Documentation</a>
	 * @param margin the right margin value
	 */
	public ClassBuilder setMarginRight(Size margin) {
		addAttrib("margin-right", margin.toString());
		return this;
	}
	
	/**
	 * Sets the top margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/top_margin.html">Documentation</a>
	 * @param margin the top margin value
	 */
	public ClassBuilder setMarginTop(Size margin) {
		addAttrib("margin-top", margin.toString());
		return this;
	}
	
	/**
	 * Sets the bottom margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/bottom_margin.html">Documentation</a>
	 * @param margin the bottom margin value
	 */
	public ClassBuilder setMarginBottom(Size margin) {
		addAttrib("margin-bottom", margin.toString());
		return this;
	}
	
	/**
	 * Sets the margin values of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/margin.html">Documentation</a>
	 * @param left   a string representation of the left margin value
	 * @param right  a string representation of the right margin value
	 * @param top    a string representation of the top margin value
	 * @param bottom a string representation of the bottom margin value
	 * @deprecated   This method was used before the Size class was created
	 *         	     I have decided to keep this in for now, however, that
	 *               may change.
	 */
	public ClassBuilder setMargin(String left, String right, String top, String bottom) {
		addAttrib("margin", left + ' ' + right + ' ' + top + ' ' + bottom );
		return this;
	}
	
	/**
	 * Sets the x and y margin values of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/margin.html">Documentation</a>
	 * @param x    a string representation of the x margin value
	 * @param y    a string representation of the y margin value
	 * @deprecated This method was used before the Size class was created
	 *         	   I have decided to keep this in for now, however, that
	 *             may change.
	 */
	public ClassBuilder setMargin(String x, String y) {
		addAttrib("margin", x + ' ' + y);
		return this;
	}
	
	/**
	 * Sets the margin values of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/margin.html">Documentation</a>
	 * @param margin a string representation of the margin value
	 * @deprecated   This method was used before the Size class was created
	 *         	     I have decided to keep this in for now, however, that
	 *               may change.
	 */
	public ClassBuilder setMargin(String margin) {
		addAttrib("margin", margin);
		return this;
	}
	
	/**
	 * Sets the left margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/left_margin.html">Documentation</a>
	 * @param margin a string representation of the left margin value
	 * @deprecated   This method was used before the Size class was created
	 *         	     I have decided to keep this in for now, however, that
	 *               may change.
	 */
	public ClassBuilder setMarginLeft(String margin) {
		addAttrib("margin-left", margin);
		return this;
	}
	
	/**
	 * Sets the right margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/right_margin.html">Documentation</a>
	 * @param margin a string representation of the right margin value
	 * @deprecated   This method was used before the Size class was created
	 *         	     I have decided to keep this in for now, however, that
	 *               may change.
	 */
	public ClassBuilder setMarginRight(String margin) {
		addAttrib("margin-right", margin);
		return this;
	}
	
	/**
	 * Sets the top margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/top_margin.html">Documentation</a>
	 * @param margin a string representation of the top margin value
	 * @deprecated   This method was used before the Size class was created
	 *         	     I have decided to keep this in for now, however, that
	 *               may change.
	 */
	public ClassBuilder setMarginTop(String margin) {
		addAttrib("margin-top", margin);
		return this;
	}
	
	/**
	 * Sets the bottom margin value of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Margin/bottom_margin.html">Documentation</a>
	 * @param margin a string representation of the bottom margin value
	 * @deprecated   This method was used before the Size class was created
	 *         	     I have decided to keep this in for now, however, that
	 *               may change.
	 */
	public ClassBuilder setMarginBottom(String margin) {
		addAttrib("margin-bottom", margin);
		return this;
	}
	
	/**
	 * Add a border to the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/border.html">Documentation</a>
	 * @param style the style of the border
	 * @param size the width of the border
	 * @param colour the colour of the border
	 */
	public ClassBuilder setBorder(String style, Size size, String colour) {
		addAttrib("border", style + " " + size.toString() + " " + colour);
		return this;
	}
	
	/**
	 * Sets the colour of the border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/border_colour.html">Documentation</a>
	 * @param colour the new border colour
	 */
	public ClassBuilder setBorderColour(String colour) {
		addAttrib("border-color", colour);
		return this;
	}
	
	/**
	 * Sets the style of the border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/border_style.html">Documentation</a>
	 * @param style the new border style
	 */
	public ClassBuilder setBorderStyle(String style) {
		addAttrib("border-style", style);
		return this;
	}
	
	/**
	 * Sets the width of the border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/border_width.html">Documentation</a>
	 * @param width the new border width
	 */
	public ClassBuilder setBorderWidth(Size width) {
		addAttrib("border-width", width.toString());
		return this;
	}
	
	/**
	 * Adds a border to the bottom of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/bottom_border.html">Documentation</a>
	 * @param style  the border style
	 * @param size   the border size
	 * @param colour the border colour
	 */
	public ClassBuilder setBorderBottom(String style, Size size, String colour) {
		addAttrib("border-bottom", style + " " + size.toString() + " " + colour);
		return this;
	}
	
	// TODO: Add in anchor points to the doco to link to.
	/**
	 * Sets the colour of the bottom border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/bottom_border.html">Documentation</a>
	 * @param colour the new border colour
	 */
	public ClassBuilder setBorderBottomColour(String colour) {
		addAttrib("border-bottom-color", colour);
		return this;
	}
	
	/**
	 * Sets the style of the bottom border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/bottom_border.html">Documentation</a>
	 * @param style the new border style
	 */
	public ClassBuilder setBorderBottomStyle(String style) {
		addAttrib("border-bottom-style", style);
		return this;
	}
	
	/**
	 * Sets the width of the bottom border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/bottom_border.html">Documentation</a>
	 * @param width the new border width
	 */
	public ClassBuilder setBorderBottomWidth(Size width) {
		addAttrib("border-bottom-width", width.toString());
		return this;
	}
	
	/**
	 * Adds a border to the left of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/left_border.html">Documentation</a>
	 * @param style the border style
	 * @param size the border size
	 * @param colour the border colour
	 */
	public ClassBuilder setBorderLeft(String style, Size size, String colour) {
		addAttrib("border-left", style + " " + size.toString() + " " + colour);
		return this;
	}
	
	/**
	 * Sets the colour of the left border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/left_border.html">Documentation</a>
	 * @param colour the new border colour
	 */
	public ClassBuilder setBorderLeftColour(String colour) {
		addAttrib("border-left-color", colour);
		return this;
	}
	
	/**
	 * Sets the style of the left border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/left_border.html">Documentation</a>
	 * @param style the new border style
	 */
	public ClassBuilder setBorderLeftStyle(String style) {
		addAttrib("border-left-style", style);
		return this;
	}
	
	/**
	 * Sets the width of the left border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/left_border.html">Documentation</a>
	 * @param width the new border width
	 */
	public ClassBuilder setBorderLeftWidth(Size width) {
		addAttrib("border-left-width", width.toString());
		return this;
	}
	
	/**
	 * Adds a border to the right of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/right_border.html">Documentation</a>
	 * @param style  the border style
	 * @param size   the border size
	 * @param colour the border colour
	 */
	public ClassBuilder setBorderRight(String style, Size size, String colour) {
		addAttrib("border-right", style + " " + size.toString() + " " + colour);
		return this;
	}
	
	/**
	 * Set the colour of the right border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/right_border.html">Documentation</a>
	 * @param colour the new border colour
	 */
	public ClassBuilder setBorderRightColour(String colour) {
		addAttrib("border-right-color", colour);
		return this;
	}
	
	/**
	 * Sets the style of the right border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/right_border.html">Documentation</a>
	 * @param style the new border style
	 */
	public ClassBuilder setBorderRightStyle(String style) {
		addAttrib("border-right-style", style);
		return this;
	}
	
	/**
	 * Sets the width of the right border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/right_border.html">Documentation</a>
	 * @param width the new border width
	 */
	public ClassBuilder setBorderRightWidth(Size width) {
		addAttrib("border-right-width", width.toString());
		return this;
	}
	
	/**
	 * Adds a border to the top of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/top_border.html">Documentation</a>
	 * @param style the border style
	 * @param size the border size
	 * @param colour the border colour
	 */
	public ClassBuilder setBorderTop(String style, Size size, String colour) {
		addAttrib("border-top", style + " " + size.toString() + " " + colour);
		return this;
	}
	
	/**
	 * Sets the colour of the top border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/top_border.html">Documentation</a>
	 * @param colour the new border colour
	 */
	public ClassBuilder setBorderTopColour(String colour) {
		addAttrib("border-top-color", colour);
		return this;
	}
	
	/**
	 * Sets the style of the top border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/top_border.html">Documentation</a>
	 * @param style the new border style
	 */
	public ClassBuilder setBorderTopStyle(String style) {
		addAttrib("border-top-style", style);
		return this;
	}
	
	/**
	 * Sets the width of the top border of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/top_border.html">Documentation</a>
	 * @param width the new border width
	 */
	public ClassBuilder setBorderTopWidth(Size width) {
		addAttrib("border-top-width", width.toString());
		return this;
	}
	
	/**
	 * Sets the border radius of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Border/border_radius.html">Documentation</a>
	 * @param radius the new border radius
	 */
	public ClassBuilder setBorderRadius(Size radius) {
		addAttrib("border-radius", radius.toString());
		return this;
	}
	
	/**
	 * Adds an outline to the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Outline/outline.html">Documentation</a>
	 * @param style  the outline style
	 * @param width  the outline width
	 * @param colour the outline colour
	 */
	public ClassBuilder setOutline(String style, Size width, String colour) {
		addAttrib("outline", style + width.toString() + colour);
		return this;
	}
	
	/**
	 * Sets the colour of the outline of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Outline/outline_colour.html">Documentation</a>
	 * @param colour the new outline colour
	 */
	public ClassBuilder setOutlineColour(String colour) {
		addAttrib("outline-color", colour);
		return this;
	}

	/**
	 * Sets the offset of the outline of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Outline/outline_offset.html">Documentation</a>
	 * @param length the length of the offset
	 */
	public ClassBuilder setOutlineOffset(Size length) {
		addAttrib("outline-offset", length.toString());
		return this;
	}
	
	/**
	 * Sets the style of the outline of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Outline/outline_style.html">Documentation</a>
	 * @param style the new outline style
	 */
	public ClassBuilder setOutlineStyle(String style) {
		addAttrib("outline-style", style);
		return this;
	}
	
	/**
	 * Sets the width of the outline of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Outline/outline_width.html">Documentation</a>
	 * @param width the new outline width
	 */
	public ClassBuilder setOutlineWidth(Size width) {
		addAttrib("outline-width", width.toString());
		return this;
	}
	
	/**
	 * Sets the text alignment of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_align.html">Documentation</a>
	 * @param alignment the new text alignment
	 */
	public ClassBuilder setTextAlign(String alignment) {
		addAttrib("text-align", alignment);
		return this;
	}
	
	/**
	 * Sets the text decoration of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_decoration.html">Documentation</a>
	 * @param decoration the new text decoration
	 */
	public ClassBuilder setTextDecoration(String decoration) {
		addAttrib("text-decoration", decoration);
		return this;
	}
	
	/**
	 * Sets the capitalisation of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_capitalisation.html">Documentation</a>
	 * @param captialisation the 
	 */
	public ClassBuilder setTextCapitalisation(String captialisation) {
		addAttrib("text-transform", captialisation);
		return this;
	}
	
	/**
	 * Sets the text indent of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_indent.html">Documentation</a>
	 * @param indent the new text indent
	 */
	public ClassBuilder setTextIndent(Size indent) {
		addAttrib("text-indent", indent.toString());
		return this;
	}
	
	/**
	 * Sets the letter spacing of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/letter_spacing.html">Documentation</a>
	 * @param spacing the new letter spacing
	 */
	public ClassBuilder setLetterSpacing(Size spacing) {
		addAttrib("letter-spacing", spacing.toString());
		return this;
	}
	
	/**
	 * Sets the line height of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/line_height.html">Documentation</a>
	 * @param height the new line height
	 */
	public ClassBuilder setLineHeight(Size height) {
		addAttrib("line-height", height.toString());
		return this;
	}
	
	/**
	 * Sets the text direction of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_direction.html">Documentation</a>
	 * @param direction the new text direction
	 */
	public ClassBuilder setTextDirection(String direction) {
		addAttrib("direction", direction.toString());
		return this;
	}
	
	/**
	 * Sets the word spacing of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/word_spacing.html">Documentation</a>
	 * @param spacing the new word spacing
	 */
	public ClassBuilder setWordSpacing(Size spacing) {
		addAttrib("word-spacing", spacing.toString());
		return this;
	}
	
	/**
	 * Adds a shadow to the text of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_shadow.html">Documentation</a>
	 * @param xOffset the shadow x-offset
	 * @param yOffset the shadow y-offset
	 * @param colour  the shadow colour
	 */
	public ClassBuilder setTextShadow(Size xOffset, Size yOffset, String colour) {
		addAttrib("text-shadow", xOffset.toString() + yOffset.toString() + colour);
		return this;
	}

	/**
	 * Specifies how overflowed content that is not 
	 * displayed should be signaled to the user.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/text_overflow.html">Documentation</a>
	 * @param overflow the method of overflow
	 */
	public ClassBuilder setTextOverflow(String overflow) {
		addAttrib("text-overflow", overflow);
		return this;
	}
	
	/**
	 * Sets whether the text should be overwritten to
	 * support multiple languages in the one document
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/unicode_bidi.html">Documentation</a>
	 * @param value
	 */
	public ClassBuilder setUnicodeBIDI(String value) {
		addAttrib("unicode-bidi", value);
		return this;
	}
	
	/**
	 * Controls how elements set next to each other
	 * on a line are lined up.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/vertical_align.html">Documentation</a>
	 * @param alignment the new vertical alignment
	 */
	public ClassBuilder setVerticalAlign(String alignment) {
		addAttrib("vertical-align", alignment);
		return this;
	}
	
	/**
	 * Specifies how white-space inside an element
	 * is handled
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Text/whitespace.html">Documentation</a>
	 * @param value the white-space attribute value
	 */
	public ClassBuilder setWhiteSpace(String value) {
		addAttrib("white-space", value);
		return this;
	}
	
	/**
	 * Sets the styling of a list element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/List/list.html">Documentation</a>
	 * @param type     the list type
	 * @param position the list position
	 * @param image    the list image
	 */
	public ClassBuilder setListStyle(String type, String position, String image) {
		addAttrib("list-style", type + ' ' + position + ' ' + image);
		return this;
	}
	
	/**
	 * Sets the type of the list element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/List/list_type.html">Documentation</a>
	 * @param type the new list type
	 */
	public ClassBuilder setListType(String type) {
		addAttrib("list-style-type", type);
		return this;
	}
	
	/**
	 * Sets the position of the list-item
	 * markers of the list element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/List/list_position.html">Documentation</a>
	 * @param position the new marker position
	 */
	public ClassBuilder setListPosition(String position) {
		addAttrib("list-style-position", position);
		return this;
	}
	
	/**
	 * Sets the image of the list item markers
	 * of the list element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/List/list_image.html">Documentation</a>
	 * @param image the new marker image
	 */
	public ClassBuilder setListImage(String image) {
		addAttrib("list-style-image", image);
		return this;
	}
	
	/**
	 * Specifies whether the borders of a table will
	 * collapse.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Table/border_collapse.html">Documentation</a>
	 * @param value the border-collapse value
	 */
	public ClassBuilder setBorderCollapse(String value) {
		addAttrib("border-collapse", value);
		return this;
	}
	
	/**
	 * Sets the distance between the borders of
	 * adjacent cells.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Table/border_spacing.html">Documentation</a>
	 * @param spacing the new border spacing
	 */
	public ClassBuilder setBorderSpacing(String spacing) {
		addAttrib("border-spacing", spacing);
		return this;
	}
	
	/**
	 * Specifies the placement of a table caption.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Table/caption_side.html">Documentation</a>
	 * @param value the table caption placement
	 */
	public ClassBuilder setCaptionSide(String value) {
		addAttrib("caption-side", value);
		return this;
	}
	
	/**
	 * Sets whether or not to display the borders of
	 * the empty cells of a table element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Table/empty_cells.html">Documentation</a>
	 * @param value the value of the empty cells attribute
	 */
	public ClassBuilder setEmptyCells(String value) {
		addAttrib("empty-cells", value);
		return this;
	}
	
	/**
	 * Sets the layout of a table element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Table/table_layout.html">Documentation</a>
	 * @param layout the new table layout
	 */
	public ClassBuilder setTableLayout(String layout) {
		addAttrib("table-layout", layout);
		return this;
	}
	
	/**
	 * Sets whether the element should be displayed
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/display.html">Documentation</a>
	 * @param value the display value
	 */
	public ClassBuilder setDisplay(String value) {
		addAttrib("display", value);
		return this;
	}
	
	/**
	 * Sets the visibility of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/visibility.html">Documentation</a>
	 * @param value the visibility
	 */
	public ClassBuilder setVisibility(String value) {
		addAttrib("visibility", value);
		return this;
	}
	
	/**
	 * Sets the position of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/position.html">Documentation</a>
	 * @param value the new position value
	 */
	public ClassBuilder setPosition(String value) {
		addAttrib("position", value);
		return this;
	}
	
	/**
	 * Sets the bottom offset of the element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/bottom.html">Documentation</a>
	 * @param bottomOffset the bottom offset
	 */
	public ClassBuilder setBottom(Size bottomOffset) {
		addAttrib("bottom", bottomOffset.toString());
		return this;
	}
	
	/**
	 * Specifies a rectangle to clip an absolutely
	 * positioned element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/clip.html">Documentation</a>
	 * @param value A rectangle for clipping
	 */
	public ClassBuilder setClip(Rectangle value) {
		addAttrib("clip", value.toString());
		return this;
	}
	
	/**
	 * Sets the left offset of an element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/left.html">Documentation</a>
	 * @param leftOffset the new left offset
	 */
	public ClassBuilder setLeft(Size leftOffset) {
		addAttrib("left", leftOffset.toString());
		return this;
	}
	
	/**
	 * Sets the right offset of an element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/right.html">Documentation</a>
	 * @param rightOffset the new right offset
	 */
	public ClassBuilder setRight(Size rightOffset) {
		addAttrib("right", rightOffset.toString());
		return this;
	}
	
	/**
	 * Sets the top offset of an element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/top.html">Documentation</a>
	 * @param topOffset the new top offset
	 */
	public ClassBuilder setTop(Size topOffset) {
		addAttrib("top", topOffset.toString());
		return this;
	}
	
	/**
	 * Specifies the stack order of an element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/z_index.html">Documentation</a>
	 * @param index the new stack order
	 */
	public ClassBuilder setZIndex(float index) {
		addAttrib("z-index", Float.toString(index));
		return this;
	}
	
	/**
	 * Specifies what should happen if content
	 * overflows the element's box.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/overflow.html">Documentation</a>
	 * @param value the new overflow value
	 */
	public ClassBuilder setOverflow(String value) {
		addAttrib("overflow", value);
		return this;
	}
	
	/**
	 * Specifies what should happen if content overflows
	 * the element's box at the left and right edges.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/overflow_x.html">Documentation</a>
	 * @param value the new overflow-x value
	 */
	public ClassBuilder setOverflowX(String value) {
		addAttrib("overflow-x", value);
		return this;
	}
	
	/**
	 * Specifies what should happen if content overflows
	 * the element's box at the top and bottom edges.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/overflow_y.html">Documentation</a>
	 * @param value the new overflow-y value
	 */
	public ClassBuilder setOverflowY(String value) {
		addAttrib("overflow-y", value);
		return this;
	}
	
	/**
	 * Specifies how the width and height of an
	 * element should be calculated.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/box_sizing.html">Documentation</a>
	 * @param value the new box-sizing value
	 */
	public ClassBuilder setBoxSizing(String value) {
		addAttrib("box-sizing", value);
		return this;
	}
	
	// TODO: Add in anchor points to the doco to link to.
	/**
	 * Specifies on which sides of an element floating
	 * elements are not allowed to float.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/float.html">Documentation</a>
	 * @param value the new clear value
	 */
	public ClassBuilder setClear(String value) {
		addAttrib("clear", value);
		return this;
	}
	
	/**
	 * Specifies how an element should float.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Display/float.html">Documentation</a>
	 * @param value the new float value
	 */
	public ClassBuilder setFloat(String value) {
		addAttrib("float", value);
		return this;
	}
	
	/**
	 * Sets the opacity of an image element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Image/opacity.html">Documentation</a>
	 * @param opacity the new opacity
	 */
	public ClassBuilder setOpacity(float opacity) {
		addAttrib("opacity", Float.toString(opacity));
		return this;
	}
	
	/**
	 * Specifies a filter to be used for an image element.
	 * See <a href="../../Documentation/HTML/Styling/Attributes/Image/filter.html">Documentation</a>
	 * @param value the new filter
	 */
	public ClassBuilder setFilter(String value) {
		addAttrib("filter", value);
		return this;
	}
	
	/**
	 * Search an XML document for a key and return a map of child keys and values.
	 * @param key the initial key to search for
	 * @return a map containing the child keys and values
	 */
	public static Map<String, String> ReadXML(String key) {
		File file = getResourceAsFile("styling.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document document = null;
		try {
			document = documentBuilder.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> values = new HashMap<String, String>();
		Node node = document.getElementsByTagName(key.toLowerCase()).item(0);
		NodeList children = ((Element) node).getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if (children.item(i).getTextContent() != null && children.item(i).getNodeName() != "#text"
					&& children.item(i).getNodeName() != "#comment") {
				values.put(children.item(i).getNodeName(), children.item(i).getTextContent());
			}
		}
		return values;
	}
	
	public static File getResourceAsFile(String resourcePath) {
		try {
			InputStream in = ClassBuilder.class.getClassLoader().getResourceAsStream(resourcePath);
			if (in == null) {
	            return null;
	        }
			File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
	        tempFile.deleteOnExit();
	        
	        try (FileOutputStream out = new FileOutputStream(tempFile)) {
	            //copy stream
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = in.read(buffer)) != -1) {
	                out.write(buffer, 0, bytesRead);
	            }
	        }
	        return tempFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Class buildClass() {
		return new Class(name, attributes);
	}

	@Override
	public Asset build() {
		return null;
	}

	@Override
	public ID buildID() {
		return null;
	}
}
