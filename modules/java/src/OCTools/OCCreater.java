package OCTools;

import java.io.File;

import OCDirector.OCDirector;
import OCValue.OCStaticValue;

/**
 * 
 * @author MingChao Sun
 *
 *         该类负责工程创建与根目录生成
 */
public class OCCreater {

	public static OCDirector director;

	public static void creatNewProject() {

		director = OCDirector.getInstance();

		/*
		 * 生成根目录
		 */
		OCDirector.RootPath = director.getProjectPath() + "/"
				+ director.getAppname();

		/*
		 * 建立顶层文件夹
		 */
		OCFolderMaker.newFolder(OCDirector.RootPath);

		/*
		 * 建立每部文件结构
		 */
		OCFolderMaker.newFolder(OCDirector.RootPath + "/css");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/img");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/js");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/xml");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/music");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/apk");
		OCFolderMaker.newFolder(OCDirector.RootPath + "/component");
		
		/*
		 * 复制js文件
		 */
		
		File srcFile1 = new File(OCStaticValue.LibraryURl+"/js/onClickFunction.js");
		File destDir = new File(OCDirector.RootPath+"/js");
		OCFileWorker.copyFile(srcFile1, destDir, "onClickFunction.js");
		
		File srcFile2 = new File(OCStaticValue.LibraryURl+"/js/onClickFunction.js");
		OCFileWorker.copyFile(srcFile2, destDir, "tools.js");
	}
}
