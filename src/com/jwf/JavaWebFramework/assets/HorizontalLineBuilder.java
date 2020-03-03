package com.jwf.JavaWebFramework.assets;

/**
 * A Horizontal Line Builder - All attributes are set and then the final horizontal line is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/Forms/horizontal_line.html#HorizontalLineBuilder">Documentation</a>
 * @see HorizontalLine
 * @see Asset
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
