package OCAttribute;

/**
 * 
 * 文本框的属性
 * @author MingChao Sun
 */
public class Attr_TextView2 {
	
	
	
	/**
	 * 要显示的文字
	 */
	private String text = "Office Coder!";

	/**
	 * 高度
	 */
	private String height = "200px";

	/**
	 * 宽度
	 */
	private String width = "300px";

	/**
	 * 文字颜色
	 */
	private String textcolor = "#fffaff";

	/**
	 * 字体大小
	 */
	private String fontsize = "13px";

	/**
	 * 背景颜色
	 */
	private String backgroundcolor = "#1284ff";
	
	/**
	 * 文字水平格式 居左 left 居右 right 居中 center
	 */
	private String horizentalmode = "left";

	/**
	 * 文字竖直格式 居中 middle 居上baseline
	 */
	private String verticalmode = "middle";

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
	
}
