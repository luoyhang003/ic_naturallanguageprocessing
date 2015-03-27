package OCAttribute;

import OCTools.OCStringUtils;



/**
 * ͼƬ�ı�����������
 * 
 * @author MingChao Sun
 *
 */
public class Attr_OCTextAndImageView {

	/**
	 * ͼƬ·��
	 */
	private String imagesrc = "";

	/**
	 * ͼƬ��������
	 */
	private String imagetext = "MyImage";

	/**
	 * ͼƬ�߶�
	 */
	private String imageheight = "230px";

	/**
	 * ���
	 */
	private String width = "360px";

	/**
	 * ����·��
	 */
	private String musicURL = "";

	/**
	 * �߿���ʽ
	 * 
	 *	ֵ	����
	 *	none	�����ޱ߿�
	 *	hidden	�� "none" ��ͬ������Ӧ���ڱ�ʱ���⣬���ڱ�hidden ���ڽ���߿��ͻ��
	 *	dotted	�����״�߿��ڴ����������г���Ϊʵ�ߡ�
	 *	dashed	�������ߡ��ڴ����������г���Ϊʵ�ߡ�
	 *	solid	����ʵ�ߡ�
	 *	double	����˫�ߡ�˫�ߵĿ�ȵ��� border-width ��ֵ��
	 *	groove	���� 3D ���۱߿���Ч��ȡ���� border-color ��ֵ��
	 *	ridge	���� 3D ¢״�߿���Ч��ȡ���� border-color ��ֵ��
	 *	inset	���� 3D inset �߿���Ч��ȡ���� border-color ��ֵ��
	 *	outset	���� 3D outset �߿���Ч��ȡ���� border-color ��ֵ��
	 *	inherit	�涨Ӧ�ôӸ�Ԫ�ؼ̳б߿���ʽ��
	 */
	private String borderStyle = "solid";

	/**
	 * �߿���
	 */
	private String borderWidth = "4px";

	/**
	 * �߿���ɫ
	 */
	private String borderColor = "#db5705";

	/**
	 * ����¼�
	 */
	private String function = "test();";

	/**
	 * Ҫ��ʾ������
	 */
	private String text = "Office Coder!";

	/**
	 * �ı���߶�
	 */
	private String textheight = "100px";

	/**
	 * ������ɫ
	 */
	private String textcolor = "#ffffff";

	/**
	 * �����С
	 */
	private String fontSize = "13px";

	/**
	 * ������ɫ
	 */
	private String backgroundcolor = "#1784ff";

	/**
	 * ����ˮƽ��ʽ ���� left ���� right ���� center
	 */
	private String horizentalmode = "left";

	/**
	 * ������ֱ��ʽ ���� middle ����baseline
	 */
	private String verticalmode = "middle";

	/**
	 * ��ɫ����padding(left)
	 */
	private String paddingleft = "10px";

	/**
	 * ��ɫ����padding(right)
	 */
	private String paddingright = "15px";

	/**
	 * ��ɫ����padding(top)
	 */
	private String paddingtop = "5px";

	/**
	 * ��ɫ����padding(bottom)
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
