package OCTools;

import java.io.File;

/**
 * 
 * @author MingChaoSun
 *
 * ���������ļ��в���������������ɾ��
 */
public class OCFolderMaker {

	/**
	 *  �½�һ���ļ���
	 * @param folderPath
	 */
	public static void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
			System.out.println("�½��ļ��в�������");
			e.printStackTrace();
		}
	}

	/**
	 *  ɾ���ļ���
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			String filePath = folderPath;
			File delPath = new File(filePath);
			delPath.delete();
		} catch (Exception e) {
			System.out.println("ɾ���ļ��в�������");
			e.printStackTrace();
		}
	}
}
