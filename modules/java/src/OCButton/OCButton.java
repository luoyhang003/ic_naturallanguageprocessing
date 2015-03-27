package OCButton;

import OCDirector.OCView;

/**
 * OCButton 所有OfficeCoder 系列 按钮类的父类
 * 
 * @author MingChao Sun
 *
 */
public class OCButton extends OCView{

	/**
	 * 按钮文字
	 */
	String text;

	

	public OCButton(String text, int height, int width) {

		this.text = text;
		this.height = height;
		this.width = width;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
