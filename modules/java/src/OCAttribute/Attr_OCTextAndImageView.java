package OCAttribute;

import OCTools.OCStringUtils;



/**
 * 图片文本框的相关属性
 * 
 * @author MingChao Sun
 *
 */
public class Attr_OCTextAndImageView {

	/**
	 * 图片路径
	 */
	private String imagesrc = "";

	/**
	 * 图片加载文字
	 */
	private String imagetext = "MyImage";

	/**
	 * 图片高度
	 */
	private String imageheight = "230px";

	/**
	 * 宽度
	 */
	private String width = "360px";

	/**
	 * 音乐路径
	 */
	private String musicURL = "";

	/**
	 * 边框样式
	 * 
	 *	值	描述
	 *	none	定义无边框。
	 *	hidden	与 "none" 相同。不过应用于表时除外，对于表，hidden 用于解决边框冲突。
	 *	dotted	定义点状边框。在大多数浏览器中呈现为实线。
	 *	dashed	定义虚线。在大多数浏览器中呈现为实线。
	 *	solid	定义实线。
	 *	double	定义双线。双线的宽度等于 border-width 的值。
	 *	groove	定义 3D 凹槽边框。其效果取决于 border-color 的值。
	 *	ridge	定义 3D 垄状边框。其效果取决于 border-color 的值。
	 *	inset	定义 3D inset 边框。其效果取决于 border-color 的值。
	 *	outset	定义 3D outset 边框。其效果取决于 border-color 的值。
	 *	inherit	规定应该从父元素继承边框样式。
	 */
	private String borderStyle = "solid";

	/**
	 * 边框宽度
	 */
	private String borderWidth = "4px";

	/**
	 * 边框颜色
	 */
	private String borderColor = "#db5705";

	/**
	 * 点击事件
	 */
	private String function = "test();";

	/**
	 * 要显示的文字
	 */
	private String text = "Office Coder!";

	/**
	 * 文本框高度
	 */
	private String textheight = "100px";

	/**
	 * 文字颜色
	 */
	private String textcolor = "#ffffff";

	/**
	 * 字体大小
	 */
	private String fontSize = "13px";

	/**
	 * 背景颜色
	 */
	private String backgroundcolor = "#1784ff";

	/**
	 * 文字水平格式 居左 left 居右 right 居中 center
	 */
	private String horizentalmode = "left";

	/**
	 * 文字竖直格式 居中 middle 居上baseline
	 */
	private String verticalmode = "middle";

	/**
	 * 纯色背景padding(left)
	 */
	private String paddingleft = "10px";

	/**
	 * 纯色背景padding(right)
	 */
	private String paddingright = "15px";

	/**
	 * 纯色背景padding(top)
	 */
	private String paddingtop = "5px";

	/**
	 * 纯色背景padding(bottom)
	 */
	private String paddingbottom = "5px";

	public String getImagesrc() {
		return imagesrc;
	}

	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}

	public String getImagetext() {
		return imagetext;
	}

	public void setImagetext(String imagetext) {
		this.imagetext = imagetext;
	}

	public String getImageheight() {
		return imageheight;
	}

	public void setImageheight(String imageheight) {
		this.imageheight = imageheight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getMusicURL() {
		return musicURL;
	}

	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}

	public String getBorderStyle() {
		return borderStyle;
	}

	public void setBorderStyle(String borderStyle) {
		this.borderStyle = borderStyle;
	}

	public String getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(String borderWidth) {
		this.borderWidth = borderWidth;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTextheight() {
		return textheight;
	}

	public void setTextheight(String textheight) {
		this.textheight = textheight;
	}

	public String getTextcolor() {
		return textcolor;
	}

	public void setTextcolor(String textcolor) {
		this.textcolor = textcolor;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getBackgroundcolor() {
		return backgroundcolor;
	}

	public void setBackgroundcolor(String backgroundcolor) {
		this.backgroundcolor = backgroundcolor;
	}

	public String getHorizentalmode() {
		return horizentalmode;
	}

	public void setHorizentalmode(String horizentalmode) {
		this.horizentalmode = horizentalmode;
	}

	public String getVerticalmode() {
		return verticalmode;
	}

	public void setVerticalmode(String verticalmode) {
		this.verticalmode = verticalmode;
	}

	public String getPaddingleft() {
		return paddingleft;
	}

	public void setPaddingleft(String paddingleft) {
		this.paddingleft = paddingleft;
	}

	public String getPaddingright() {
		return paddingright;
	}

	public void setPaddingright(String paddingright) {
		
		int pright = OCStringUtils.dropPX(paddingright);
		
		pright = pright + 5;
		
		this.paddingright = pright + "px";
	}

	public String getPaddingtop() {
		return paddingtop;
	}

	public void setPaddingtop(String paddingtop) {
		this.paddingtop = paddingtop;
	}

	public String getPaddingbottom() {
		return paddingbottom;
	}

	public void setPaddingbottom(String paddingbottom) {
		this.paddingbottom = paddingbottom;
	}

}
