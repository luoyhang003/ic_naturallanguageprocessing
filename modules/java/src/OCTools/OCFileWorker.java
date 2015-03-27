package OCTools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.channels.FileChannel;

/**
 * 
 * @author MingChao Sun
 *
 *         �ļ���������
 */
public class OCFileWorker {

	/**
	 * �����ļ�
	 * 
	 * @param srcFile
	 *            Դ�ļ�File
	 * @param destDir
	 *            Ŀ��Ŀ¼File
	 * @param newFileName
	 *            ���ļ���
	 * @return ʵ�ʸ��Ƶ��ֽ���������ļ���Ŀ¼�����ڡ��ļ�Ϊnull���߷���IO�쳣������-1
	 */
	public static long copyFile1(File srcFile, File destDir, String newFileName) {
		long copySizes = 0;
		if (!srcFile.exists()) {
			System.out.println("Դ�ļ�������");
			copySizes = -1;
		} else if (!destDir.exists()) {
			System.out.println("Ŀ��Ŀ¼������");
			copySizes = -1;
		} else if (newFileName == null) {
			System.out.println("�ļ���Ϊnull");
			copySizes = -1;
		} else {
			try {
				BufferedInputStream bin = new BufferedInputStream(
						new FileInputStream(srcFile));
				BufferedOutputStream bout = new BufferedOutputStream(
						new FileOutputStream(new File(destDir, newFileName)));
				int b = 0, i = 0;
				while ((b = bin.read()) != -1) {
					bout.write(b);
					i++;
				}
				bout.flush();
				bin.close();
				bout.close();
				copySizes = i;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return copySizes;
	}

	/**
	 * �����ļ�(�Գ�����ٶȸ����ļ�)
	 * 
	 * @param srcFile
	 *            Դ�ļ�File
	 * @param destDir
	 *            Ŀ��Ŀ¼File
	 * @param newFileName
	 *            ���ļ���
	 * @return ʵ�ʸ��Ƶ��ֽ���������ļ���Ŀ¼�����ڡ��ļ�Ϊnull���߷���IO�쳣������-1
	 */
	@SuppressWarnings("resource")
	public static long copyFile(File srcFile, File destDir, String newFileName) {
		long copySizes = 0;
		if (!srcFile.exists()) {
			System.out.println("Դ�ļ�������"+newFileName);
			copySizes = -1;
		} else if (!destDir.exists()) {
			System.out.println("Ŀ��Ŀ¼������");
			copySizes = -1;
		} else if (newFileName == null) {
			System.out.println("�ļ���Ϊnull");
			copySizes = -1;
		} else {
			try {
				FileChannel fcin = new FileInputStream(srcFile).getChannel();
				FileChannel fcout = new FileOutputStream(new File(destDir,
						newFileName)).getChannel();
				long size = fcin.size();
				fcin.transferTo(0, fcin.size(), fcout);
				fcin.close();
				fcout.close();
				copySizes = size;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return copySizes;
	}

}
