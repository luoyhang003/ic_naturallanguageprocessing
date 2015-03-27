package OCTools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * * @author MingChao Sun
 * 
 * @versions 1.0 ͼƬѹ�������� �ṩ�ķ����п����趨���ɵ� ����ͼƬ�Ĵ�С�ߴ��
 */
public class OCImageUtils {
	/** * ͼƬ�ļ���ȡ * * @param srcImgPath * @return */
	private static BufferedImage InputImage(String srcImgPath) {
		BufferedImage srcImage = null;
		try {
			FileInputStream in = new FileInputStream(srcImgPath);
			srcImage = javax.imageio.ImageIO.read(in);
		} catch (IOException e) {
			System.out.println("��ȡͼƬ�ļ�����" + e.getMessage());
			e.printStackTrace();
		}
		return srcImage;
	}

	/**
	 * * ��ͼƬ����ָ����ͼƬ�ߴ�ѹ�� * * @param srcImgPath :ԴͼƬ·�� * @param outImgPath *
	 * :�����ѹ��ͼƬ��·�� * @param new_w * :ѹ�����ͼƬ�� * @param new_h * :ѹ�����ͼƬ��
	 */
	public static void compressImage(String srcImgPath, String outImgPath,
			int new_w, int new_h) {
		BufferedImage src = InputImage(srcImgPath);
		disposeImage(src, outImgPath, new_w, new_h);
	}

	/**
	 * * ָ�������߿�����ֵ��ѹ��ͼƬ * * @param srcImgPath * :ԴͼƬ·�� * @param outImgPath *
	 * :�����ѹ��ͼƬ��·�� * @param maxLength * :�����߿�����ֵ
	 */
	public static void compressImage(String srcImgPath, String outImgPath,
			int maxLength) {
		// �õ�ͼƬ
		BufferedImage src = InputImage(srcImgPath);
		if (null != src) {
			int old_w = src.getWidth();
			// �õ�Դͼ��
			int old_h = src.getHeight();
			// �õ�Դͼ��
			int new_w = 0;
			// ��ͼ�Ŀ�
			int new_h = 0;
			// ��ͼ�ĳ�
			// ����ͼƬ�ߴ�ѹ���ȵõ���ͼ�ĳߴ�
			if (old_w > old_h) {
				// ͼƬҪ���ŵı���
				new_w = maxLength;
				new_h = (int) Math.round(old_h * ((float) maxLength / old_w));
			} else {
				new_w = (int) Math.round(old_w * ((float) maxLength / old_h));
				new_h = maxLength;
			}
			disposeImage(src, outImgPath, new_w, new_h);
		}
	}

	/** * ����ͼƬ * * @param src * @param outImgPath * @param new_w * @param new_h */
	private synchronized static void disposeImage(BufferedImage src,
			String outImgPath, int new_w, int new_h) {
		// �õ�ͼƬ
		int old_w = src.getWidth();
		// �õ�Դͼ��
		int old_h = src.getHeight();
		// �õ�Դͼ��
		BufferedImage newImg = null;
		// �ж�����ͼƬ������
		switch (src.getType()) {
		case 13:
			// png,gifnewImg = new BufferedImage(new_w, new_h,
			// BufferedImage.TYPE_4BYTE_ABGR);
			break;
		default:
			newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			break;
		}
		Graphics2D g = newImg.createGraphics();
		// ��ԭͼ��ȡ��ɫ������ͼ
		g.drawImage(src, 0, 0, old_w, old_h, null);
		g.dispose();
		// ����ͼƬ�ߴ�ѹ���ȵõ���ͼ�ĳߴ�
		newImg.getGraphics().drawImage(
				src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0,
				null);
		// ���÷������ͼƬ�ļ�
		OutImage(outImgPath, newImg);
	}

	/**
	 * * ��ͼƬ�ļ������ָ����·���������趨ѹ������ * * @param outImgPath * @param newImg * @param
	 * per
	 */
	private static void OutImage(String outImgPath, BufferedImage newImg) {
		// �ж�������ļ���·���Ƿ���ڣ��������򴴽�
		File file = new File(outImgPath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}// ������ļ���
		try {
			ImageIO.write(newImg,
					outImgPath.substring(outImgPath.lastIndexOf(".") + 1),
					new File(outImgPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
