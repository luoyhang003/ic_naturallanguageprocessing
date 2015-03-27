package OCValue;


/**
 * 
 * @author MingChao Sun
 * 
 * 用来描述rgb颜色的颜色类
 * 
 * RGBA是代表Red（红色 0-255）Green（绿色 0-255）Blue（蓝色 0-255）
 * 
 * 
 */
public class OCRgbColor {

	int R = 255;
	int G = 255;
	int B = 255;
	
	public OCRgbColor(int R,int G,int B){
		this.R = R;
		this.G = G;
		this.B = B;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}
	
	
	
}
