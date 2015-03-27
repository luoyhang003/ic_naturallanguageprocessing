package OCAnimation;

import java.io.File;

import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCValue.OCStaticValue;


/**
 * 人物摇头音乐动画
 * 
 * @author MingChao Sun
 *
 */
public class OCAnimation_LoveMusic extends OCView{

	public OCAnimation_LoveMusic(){
		
		width = 600;
		
		height = 600;
		
		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCAnimation_LoveMusic.html");
		
		File srcFile2 = new File(OCStaticValue.LibraryURl
				+ "/css/OCAnimationLoveMusic.css");
		
		File destDir1 = new File(OCDirector.RootPath + "/component");
		
		File destDir2 = new File(OCDirector.RootPath + "/css");
		
		OCFileWorker.copyFile(srcFile1, destDir1, "No" + OCStaticValue.OCid
				+ "OCAnimation_LoveMusic.html");

		OCFileWorker.copyFile(srcFile2, destDir2,"OCAnimationLoveMusic.css");
		
		
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCAnimation_LoveMusic.html";

		Html = "No" + OCStaticValue.OCid + "OCAnimation_LoveMusic.html";
		OCStaticValue.OCid++;
	}
	
}
