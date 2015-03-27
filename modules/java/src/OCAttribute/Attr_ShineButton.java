package OCAttribute;

/**
 * 页面的相关属性
 * 
 * @author MingChao Sun
 *
 */
public class Attr_ShineButton {

	/**
	 * 按钮文字
	 */
	private String text = "发光的按钮";

	/**
	 * 高度
	 */
	private String height = "80px";

	/**
	 * 宽度
	 */
	private String width = "200px";

	/**
	 * 文字颜色
	 */
	private String textcolor = "#ffffff";

	/**
	 * 字体大小
	 */
	private String fontsize = "23px";

	/**
	 * 背景颜色
	 */
	private String backgroundcolor = "blue";

	/**
	 * 点击事件
	 */
	private String function = "test()";

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

	public String getTextcolor() {
		return textcolor;
	}

	public void setTextcolor(String textcolor) {
		this.textcolor = textcolor;
	}

	public String getFontsize() {
		return fontsize;
	}

	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}

	public String getBackgroundcolor() {
		return backgroundcolor;
	}

	public void setBackgroundcolor(String backgroundcolor) {
		this.backgroundcolor = backgroundcolor;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}
