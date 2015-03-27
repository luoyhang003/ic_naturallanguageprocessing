package OCTest;

import java.io.File;

import OCDirector.OCDirector;
import OCTools.OCFileWorker;
import OCTools.OCFolderMaker;
import OCValue.OCStaticValue;

import com.officecoder.xml.XMLReader;

public class XMLReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XMLReader reader = new XMLReader();
		reader.XMLToHTML("C://OfficeCoder/5c933fabed1a469c85fe70f93546ccdb/test1/xml/sourceXML.xml");
	}
	
	public static void creatNewProject() {

		OCDirector director = OCDirector.getInstance();

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
