package OCValue;

/**
 * 
 * @author MingChao Sun
 * 
 *         ��������rgba��ɫ����ɫ��
 * 
 *         RGBA�Ǵ���Red����ɫ 0-255��Green����ɫ 0-255��Blue����ɫ 0-255����Alpha��0-1����ɫ�ʿռ�
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