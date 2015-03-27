package OCAttribute;

/**
 * 页面的相关属性
 * 
 * @author MingChao Sun
 *
 */
public class Attr_Button_Flat {
	/**
	 * 按钮文字
	 */
	private String text = "我的按钮";
	/**
	 * 文字颜色
	 */
	private String textcolor = "#ffffff";

	public String getTextcolor() {
		return textcolor;
	}

	public void setTextcolor(String textcolor) {
		this.textcolor = textcolor;
	}

	/**
	 * 高度
	 */
	private String height = "100px";

	/**
	 * 宽度
	 */
	private String width = "160px";

	/**
	 * 背景颜色
	 */
	private String backgroundcolor = "#1784ff";
	/**
	 * 字体大小
	 */
	private String fontSize="30px";

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

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
