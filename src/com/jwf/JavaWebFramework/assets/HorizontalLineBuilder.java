package com.jwf.JavaWebFramework.assets;

/**
 * A Horizontal Line Builder - All attributes are set and then the final horizontal line is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/horizontal_lines.html#HorizontalLineBuilder">Documentation</a>
 * @see Asset
 * @see HorizontalLine
 */
public class HorizontalLineBuilder extends Builder<HorizontalLine> {

	/**
	 * Builds the horizontal line.
	 * @return	the constructed horizontal line
	 */
	@Override
	public Asset build() {
		return new HorizontalLine();
	}
}
