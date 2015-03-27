package OCAttribute;

/**
 * ImageView �������
 * 
 * 
 * @author MingChao Sun
 *
 */
public class Attr_OCImageView {
	
	/**
	 * ͼƬ·��
	 */
	private String srcURL = "";

	
	/**
	 * �������ı�
	 */
	private String text = "MyImage";

	/**
	 * �߶�
	 */
	private String height = "200px";

	/**
	 * ���
	 */
	private String width = "360px";

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
	private String radius="0px";
	
	/**
	 * ����·��
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
	 * �õ��߿���ʽ
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
	public String getBorderStyle() {
		return borderStyle;
	}

	/**
	 * ���ñ߿���ʽ
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
