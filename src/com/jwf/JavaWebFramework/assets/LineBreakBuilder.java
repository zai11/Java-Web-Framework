package com.jwf.JavaWebFramework.assets;

/**
 * A Line Break Builder - All attributes are set and then the final line break is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/line_break.html#LineBreakBuilder">Documentation</a>
 * @see Asset
 * @see LineBreak
 */
public class LineBreakBuilder extends Builder<LineBreak> {

	/**
	 * Builds the line break.
	 * @return the constructed line break
	 */
	@Override
	public Asset build() {
		return new LineBreak();
	}
}
