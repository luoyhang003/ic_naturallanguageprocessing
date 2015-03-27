package OCValue;

/**
 * 
 * @author MingChao Sun
 * 
 *         用来描述rgba颜色的颜色类
 * 
 *         RGBA是代表Red（红色 0-255）Green（绿色 0-255）Blue（蓝色 0-255）和Alpha（0-1）的色彩空间
 * 
 * 
 */
public class OCRgbaColor {

	int R = 255;
	int G = 255;
	int B = 255;

	double A = 1;

	public OCRgbaColor(int R, int G, int B, double A) {
		this.R = R;
		this.G = G;
		this.B = B;
		this.A = A;
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

	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

}
