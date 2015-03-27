package OCAttribute;

/**
 * 开关样式二的属性
 * 
 * @author MingChao Sun
 *
 */
public class Attr_OCSwitch1 {

	/**
	 * 高度
	 */
	private String height = "50px";

	/**
	 * 宽度
	 */
	private String width = "180px";
	
	/**
	 * 圆度
	 */
	private String radius = "40px";


	/**
	 * 相关音频路径
	 */
	private String musicURL = "";

	/**
	 * 点击事件
	 */
	private String function = "test()";
	

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

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	
	public String getMusicURL() {
		return musicURL;
	}

	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	

}
