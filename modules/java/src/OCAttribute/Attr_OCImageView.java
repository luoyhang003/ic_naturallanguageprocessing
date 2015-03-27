package OCAttribute;

/**
 * ImageView 相关属性
 * 
 * 
 * @author MingChao Sun
 *
 */
public class Attr_OCImageView {
	
	/**
	 * 图片路径
	 */
	private String srcURL = "";

	
	/**
	 * 描述性文本
	 */
	private String text = "MyImage";

	/**
	 * 高度
	 */
	private String height = "200px";

	/**
	 * 宽度
	 */
	private String width = "360px";

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
	private String radius="0px";
	
	/**
	 * 音乐路径
	 */
	private String musicURL = "";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * 得到边框样式
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
	public String getBorderStyle() {
		return borderStyle;
	}

	/**
	 * 设置边框样式
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

	public String getMusicURL() {
		return musicURL;
	}

	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}

	public String getSrcURL() {
		return srcURL;
	}

	public void setSrcURL(String srcURL) {
		this.srcURL = srcURL;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}	
	
}
