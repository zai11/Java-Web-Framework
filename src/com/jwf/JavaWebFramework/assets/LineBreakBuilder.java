package com.jwf.JavaWebFramework.assets;

import com.jwf.JavaWebFramework.styling.Class;
import com.jwf.JavaWebFramework.styling.ID;

/**
 * A Line Break Builder - All attributes are set and then the final line break is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/line_break.html#LineBreakBuilder">Documentation</a>
 * @see LineBreak
 * @see Asset
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

	/**
	 * To be removed.
	 */
	@Override
	public Class buildClass() {
		return null;
	}

	/**
	 * To be removed.
	 */
	@Override
	public ID buildID() {
		return null;
	}
}
