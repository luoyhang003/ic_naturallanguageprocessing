package OCValue;


/**
 * 
 * @author MingChao Sun
 * 
 * ��������rgb��ɫ����ɫ��
 * 
 * RGBA�Ǵ���Red����ɫ 0-255��Green����ɫ 0-255��Blue����ɫ 0-255��
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
