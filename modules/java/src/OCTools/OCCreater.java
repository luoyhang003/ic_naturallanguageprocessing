package OCTools;

import java.io.File;

import OCDirector.OCDirector;
import OCValue.OCStaticValue;

/**
 * 
 * @author MingChao Sun
 *
 *         ���ฺ�𹤳̴������Ŀ¼����
 */
public class OCCreater {

	public static OCDirector director;

	public static void creatNewProject() {

		director = OCDirector.getInstance();

		/*
		 * ���ɸ�Ŀ¼
		 */
		OCDirector.RootPath = director.getProjectPath() + "/"
				+ director.getAppname();

		/*
		 * ���������ļ���
		 */
		OCFolderMaker.newFolder(OCDirector.RootPath);

		/*
		 * ����ÿ���ļ��ṹ
		 */
		OCFolderMaker.newFolder(OCDirector.RootPath + "/css");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/img");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/js");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/xml");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/music");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/apk");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/component");
		
		/*
		 * ����js�ļ�
		 */
		
		File srcFile1 = new File(OCStaticValue.LibraryURl+"/js/onClickFunction.js");
		File destDir = new File(OCDirector.RootPath+"/js");
		OCFileWorker.copyFile(srcFile1, destDir, "onClickFunction.js");
		
		File srcFile2 = new File(OCStaticValue.LibraryURl+"/js/onClickFunction.js");
		OCFileWorker.copyFile(srcFile2, destDir, "tools.js");
	}
}
