package OCAttribute;

public class Attr_TextView1 {
	/**
	 * 要显示的文字
	 */
	private String text = "Office Coder!";

	/**
	 * 高度
	 */
	private String height = "100px";

	/**
	 * 宽度
	 */
	private String width = "160px";

	/**
	 * 文字颜色
	 */
	private String textcolor = "#000000";

	/**
	 * 字体大小
	 */
	private String fontsize = "20px";

	/**
	 * 背景颜色
	 */
	private String startcolor = "#ece4d9";
	
	private String endcolor = "#e9dfd1";
	
	private String isradius="20px";
	

	public Attr_TextView1(){
		
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		char[] charArray = text.toCharArray();
		String result="";
		for(int i=0;i<charArray.length;i++){
			if(charArray[i]==' '){
				result+="@";
			}else{
				result+=charArray[i];
			}
		}
//		System.out.println(result);
		this.text = result;
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


	public String getStartcolor() {
		return startcolor;
	}


	public void setStartcolor(String startcolor) {
		this.startcolor = startcolor;
	}


	public String getEndcolor() {
		return endcolor;
	}


	public void setEndcolor(String endcolor) {
		this.endcolor = endcolor;
	}


	public String getIsradius() {
		return isradius;
	}


	public void setIsradius(String isradius) {
		this.isradius = isradius;
	}
	
	
}
