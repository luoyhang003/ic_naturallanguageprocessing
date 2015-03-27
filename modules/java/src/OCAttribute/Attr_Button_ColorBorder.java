package OCAttribute;

/**
 * 页面的相关属性
 * 
 * @author MingChao Sun
 *
 */
public class Attr_Button_ColorBorder {

	/**
	 * 按钮文字
	 */
	private String text = "我的按钮";

	/**
	 * 高度
	 */
	private String height = "100px";

	/**
	 * 宽度
	 */
	private String width = "200px";

	/**
	 * 文字颜色
	 */
	private String textcolor = "#6F6F6F";

	/**
	 * 字体大小
	 */
	private String fontsize = "30px";
	/**
	 * 边框的颜色
	 */
	private String bordercolor="#FF6138";
	/**
	 * 点击之后边框的颜色
	 * @return
	 */
	private String downcolor="#ffff38";
	public String getDowncolor() {
		return downcolor;
	}

	public void setDowncolor(String downcolor) {
		this.downcolor = downcolor;
	}

	public String getBordercolor() {
		return bordercolor;
	}

	public void setBordercolor(String bordercolor) {
		this.bordercolor = bordercolor;
	}

	/**
	 * 点击事件
	 */
	private String function = "jumpToNewWin();";

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

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}
