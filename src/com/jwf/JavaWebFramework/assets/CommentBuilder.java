package com.jwf.JavaWebFramework.assets;

/**
 * A Comment Builder - All attributes are set and then the final comment is then constructed.
 * See <a href="../../../Documentation/HTML/Assets/General/comments.html#CommentBuilder">Documentation</a>
 * @see Asset
 * @see Comment
 */
public class CommentBuilder extends Builder<Comment> {

	private String text;
	
	/**
	 * Sets the text of the comment.
	 * @param 	text	the text to be set
	 * @return	the CommentBuilder object
	 */
	public CommentBuilder setText(String text) {
		this.text = text;
		return this;
	}

	/**
	 * Builds the comment.
	 * @return the constructed comment
	 */
	@Override
	public Asset build() {
		return new Comment(text);
	}
}
