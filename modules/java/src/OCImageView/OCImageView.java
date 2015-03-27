package OCImageView;

import java.io.File;


import OCAttribute.Attr_OCImageView;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * ����ͼƬʹ�õ�ImageView
 * 
 * @author MingChao Sun
 *
 */
public class OCImageView extends OCView{
	
	public Attr_OCImageView attr;

	public OCImageView(String imgURL, int height, int width) {
		super();

		this.width = width;
		this.height = height;
		

		attr = new Attr_OCImageView();

		/*
		 * ��������bean
		 */
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");
		

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCimageView.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCimageView.html");

		File srcimg = new File(imgURL);
		
		File imgDir = new File(OCDirector.RootPath + "/img");
		
		String[] temp = imgURL.split("/");
		String name = "OCImageView" +temp[temp.length - 1];
		
		OCFileWorker.copyFile(srcimg,imgDir, name);
		
		attr.setSrcURL("../img/" + name);
		
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCimageView.html";

		Html = "No" + OCStaticValue.OCid + "OCimageView.html";
		
		OCStaticValue.OCid++;
		
		/*
		 * ����json
		 */
		attrJson = OCJsonWorker.BeanToJson(attr);

		/*
		 * �滻json
		 */
		OCHtmlWorker.ChangeJsonblock(Path, attrJson);
	}

	public void setAttr(Object attrbean) {

		/*
		 * ����json
		 */
		attrJson = OCJsonWorker.BeanToJson(attrbean);

		/*
		 * �滻json
		 */
		OCHtmlWorker.ChangeJsonblock(Path, attrJson);
	}

	public void setAttr() {
		/*
		 * ����json
		 */
		attrJson = OCJsonWorker.BeanToJson(attr);

		/*
		 * �滻json
		 */
		OCHtmlWorker.ChangeJsonblock(Path, attrJson);
	}


}
