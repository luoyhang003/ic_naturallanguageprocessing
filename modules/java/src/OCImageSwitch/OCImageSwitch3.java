package OCImageSwitch;

import java.io.File;

import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCImageUtils;
import OCValue.OCStaticValue;

/**
 * 
 * ���ռ���
 * 
 * @author MingChao Sun
 *
 */
public class OCImageSwitch3 extends OCView {

	public OCImageSwitch3() {
		super();

		this.height = 400;
		this.width = 500;

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCImageSwitch3.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCImageSwitch3.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCImageSwitch3.html";

		Html = "No" + OCStaticValue.OCid + "OCImageSwitch3.html";
		
		String srcimg1 = OCStaticValue.LibraryURl+"/img/left.gif";
		String srcimg2 = OCStaticValue.LibraryURl+"/img/right.gif";
		String srcimg3 = OCStaticValue.LibraryURl+"/img/scroll-left.gif";
		String srcimg4 = OCStaticValue.LibraryURl+"/img/scroll-right.gif";
				
		File srcFile_img1 = new File(srcimg1);
		File srcFile_img2 = new File(srcimg2);
		File srcFile_img3 = new File(srcimg3);
		File srcFile_img4 = new File(srcimg4);

		File Dir = new File(OCDirector.RootPath + "/img");

		String[] temp1 = srcimg1.split("/");
		String name1 = "OCImageSwitch3" +temp1[temp1.length - 1];
		OCFileWorker.copyFile(srcFile_img1, Dir, name1);

		String[] temp2 = srcimg2.split("/");
		String name2 = "OCImageSwitch3" +temp2[temp2.length - 1];
		OCFileWorker.copyFile(srcFile_img2, Dir, name2);

		String[] temp3 = srcimg3.split("/");
		String name3 = "OCImageSwitch3" +temp3[temp3.length - 1];
		OCFileWorker.copyFile(srcFile_img3, Dir, name3);

		String[] temp4 = srcimg4.split("/");
		String name4 = "OCImageSwitch3" +temp4[temp4.length - 1];
		OCFileWorker.copyFile(srcFile_img4, Dir, name4);

		OCStaticValue.OCid++;


	}

	/**
	 * ��ؼ��м���ͼƬ�ķ���
	 * 
	 * @param musicName
	 * @param musicURL
	 */
	public void addimg(String labelTitle, String label, String ImageSourceURL) {
		
		/*
		 * ������ͼƬѹ��
		 */
		String[] temp = ImageSourceURL.split("/");
		String name ="OCImageSwitch3" + temp[temp.length - 1];
		
		/**
		 * ͼƬ��ַ
		 */
		String ImgURL = OCDirector.RootPath + "/img/" + name;
		
		/**
		 * ����ͼ��ַ
		 */
		String thumbnailsImgURL = OCDirector.RootPath + "/img/thumbnails" + name;
		
		/*
		 * ͼƬ
		 */
		OCImageUtils.compressImage(ImageSourceURL, ImgURL, 500);
		
		/*
		 * ����ͼ
		 */
		OCImageUtils.compressImage(ImageSourceURL, thumbnailsImgURL, 125);
		

		String innerHtml = "<li><h3>" + labelTitle + "</h3><span>" + ImgURL
				+ "</span><p>" + label + "</p><a href=\"#\"><img src=\""
				+ thumbnailsImgURL + "\" alt=\"" + labelTitle
				+ "\" /></a></li>";

		OCHtmlWorker.innerHtml(Path, "#slideshow", innerHtml);

	}
}
