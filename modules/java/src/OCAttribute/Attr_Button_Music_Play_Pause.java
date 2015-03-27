package OCAttribute;

/**
 * 页面的相关属性
 * 
 * @author MingChao Sun
 *
 */
public class Attr_Button_Music_Play_Pause {

	/**
	 * 高度
	 */
	private String height = "100px";

	/**
	 * 宽度
	 */
	private String width = "200px";
	/**
	 * 图片的高度
	 */
	private String bgheight = "80px";
	/**
	 * 图片的宽度
	 */
	private String bgwidth = "80px";
	/**
	 * 图片到顶点的距离
	 */
	private String distop = "10px";
	/**
	 * 图片到左边的距离
	 */
	private String disleft = "60px";

	/**
	 * 背景颜色
	 */
	private String bgcolor = "#1784ff";
	
	private String margin = "0px";
	
	/**
	 * 相关音频路径
	 */
	private String musicURL = "../music/old memory.mp3";
	/**
	 * 音乐是否是用户上传的，如果不是需要将音乐复制到相关的文件夹，默认不是
	 */
	private boolean flag = false;

	/**
	 * 点击事件
	 */
	private String function = "music";

	/**
	 * 按钮的形状 1 表示矩形 2 表示圆形 3 表示菱形
	 */
	private int shapemode = 1;
	
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

	public String getBgheight() {
		return bgheight;
	}

	public void setBgheight(String bgheight) {
		this.bgheight = bgheight;
	}

	public String getBgwidth() {
		return bgwidth;
	}

	public void setBgwidth(String bgwidth) {
		this.bgwidth = bgwidth;
	}

	public String getDistop() {
		return distop;
	}

	public void setDistop(String distop) {
		this.distop = distop;
	}

	public String getDisleft() {
		return disleft;
	}

	public void setDisleft(String disleft) {
		this.disleft = disleft;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public int getShapemode() {
		return shapemode;
	}

	public void setShapemode(int shapemode) {
		this.shapemode = shapemode;
	}

}
