package OCAttribute;

/**
 * ҳ����������
 * 
 * @author MingChao Sun
 *
 */
public class Attr_Button_ColorBorder {

	/**
	 * ��ť����
	 */
	private String text = "�ҵİ�ť";

	/**
	 * �߶�
	 */
	private String height = "100px";

	/**
	 * ���
	 */
	private String width = "200px";

	/**
	 * ������ɫ
	 */
	private String textcolor = "#6F6F6F";

	/**
	 * �����С
	 */
	private String fontsize = "30px";
	/**
	 * �߿����ɫ
	 */
	private String bordercolor="#FF6138";
	/**
	 * ���֮��߿����ɫ
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
	 * ����¼�
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
