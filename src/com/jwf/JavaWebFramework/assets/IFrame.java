package com.jwf.JavaWebFramework.assets;

import java.util.List;

import com.jwf.JavaWebFramework.misc.collections.Assets;
import com.jwf.JavaWebFramework.styling.ID;
import com.jwf.JavaWebFramework.styling.Class;

/**
 * An IFrame - equivalent to the HTML {@code <iframe>} tags.
 * See <a href="../../Documentation/HTML/Assets/General/iframes.html">Documentation</a>
 * @see Asset
 */
public class IFrame extends Asset {

	String align;
	boolean allowFullscreen;
	boolean allowPaymentRequest;
	boolean frameBorder;
	float height;
	String longDesc;
	float marginHeight;
	float marginWidth;
	String name;
	String referrerPolicy;
	String sandbox;
	String scrolling;
	String src;
	String srcDoc;
	float width;

	/**
	 * Constructs an IFrame using the given parameters.
	 * @param src					the source page to be displayed
	 * @param name					the name given to the iframe
	 * @param align					the alignment of the iframe
	 * @param allowFullscreen		whether the iframe can activate fullscreen mode or not
	 * @param allowPaymentRequest	whether the iframe should be able to invoke the Payment Request API or not
	 * @param frameBorder			whether to display a border around the iframe or not
	 * @param height				the height of the iframe
	 * @param longDesc				a page that contains a long description of the content of the iframe
	 * @param marginHeight			the top and bottom margins of the iframe
	 * @param marginWidth			the left and right margins of the iframe
	 * @param referrerPolicy		the referrer policy used when processing the iframe attributes
	 * @param sandbox				enable an extra set of restrictions for the content in the iframe
	 * @param scrolling				whether to display a scrollbar in the iframe or not
	 * @param srcDoc				the html content of the page to show in the iframe
	 * @param width					the width of the iframe
	 * @param id					the CSS id of the iframe
	 * @param classes				any CSS classes to be attached
	 */
	public IFrame(String src, String name, String align, boolean allowFullscreen, boolean allowPaymentRequest,
			boolean frameBorder, float height, String longDesc, float marginHeight, float marginWidth,
			String referrerPolicy, String sandbox, String scrolling, String srcDoc, float width, ID id,
			List<Class> classes) {
		this.assetType = Assets.IFRAME;
		this.src = src;
		this.name = name;
		this.align = align;
		this.allowFullscreen = allowFullscreen;
		this.allowPaymentRequest = allowPaymentRequest;
		this.frameBorder = frameBorder;
		this.height = height;
		this.longDesc = longDesc;
		this.marginHeight = marginHeight;
		this.marginWidth = marginWidth;
		this.referrerPolicy = referrerPolicy;
		this.sandbox = sandbox;
		this.scrolling = scrolling;
		this.srcDoc = srcDoc;
		this.width = width;
		this.id = id;
		this.classes = classes;
	}

	/**
	 * Builds the HTML line for the iframe based
	 * on the set variables.
	 * @return the HTML line
	 */
	@Override
	public String buildLine() {
		String line = "<iframe";
		if (!src.isEmpty())
			line += " src=\"" + src + "\"";
		if (name != null && !name.isEmpty())
			line += " name=\"" + name + "\"";
		if (align != null && !align.isEmpty())
			line += " align=\"" + align + "\"";
		if (allowFullscreen)
			line += " allowfullscreen=\"" + allowFullscreen + "\"";
		if (allowPaymentRequest)
			line += " allowpaymentrequest=\"" + allowPaymentRequest + "\"";
		if (frameBorder)
			line += " frameborder=\"1\"";
		if (height != -1f)
			line += " height=\"" + height + "\"";
		if (longDesc != null && !longDesc.isEmpty())
			line += " longdesc=\"" + longDesc + "\"";
		if (marginHeight != -1f)
			line += " marginheight=\"" + marginHeight + "\"";
		if (marginWidth != -1f)
			line += " marginwidth=\"" + marginWidth + "\"";
		if (referrerPolicy != null && !referrerPolicy.isEmpty())
			line += " referrerpolicy=\"" + referrerPolicy + "\"";
		if (sandbox != null && !sandbox.isEmpty())
			line += " sandbox=\"" + sandbox + "\"";
		if (scrolling != null && !scrolling.isEmpty())
			line += " scrolling=\"" + scrolling + "\"";
		if (srcDoc != null && !srcDoc.isEmpty())
			line += " srcdoc=\"" + srcDoc + "\"";
		if (width != -1f)
			line += " width=\"" + width + "\"";
		if (classes != null) {
			line += " class='";
			for (Class c : classes) {
				line += c.getName();
			}
			line += "'";
		}
		if (id != null)
			line += " id='" + id.getValue() + "'";
		return line;
	}
}