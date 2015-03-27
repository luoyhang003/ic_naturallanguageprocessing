package OCTools;

import java.io.File;

/**
 * 
 * @author MingChaoSun
 *
 * 该类用于文件夹操作，包括创建于删除
 */
public class OCFolderMaker {

	/**
	 *  新建一个文件夹
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
			System.out.println("新建文件夹操作出错");
			e.printStackTrace();
		}
	}

	/**
	 *  删除文件夹
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			String filePath = folderPath;
			File delPath = new File(filePath);
			delPath.delete();
		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();
		}
	}
}
