package OCButton;

import java.io.File;


import OCAttribute.Attr_Button_Green;
import OCDirector.OCDirector;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * ��ɫ����ͼƬ��Button�����ܸı䱳��
 * @author xing
 *
 */

public class OCButton_Green extends OCButton {

	public Attr_Button_Green attr;

	public OCButton_Green(String text, int height, int width) {
		super(text, height, width);

		this.width = width;
		this.height = height;
		this.text = text;

		attr = new Attr_Button_Green();

		/*
		 * ��������bean
		 */
		attr.setText(text);
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCButton_Green.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCButton_Green.html");

		File srcFile2 = new File(OCStaticValue.LibraryURl
				+ "/img/bg38.png");
		File destDir2 = new File(OCDirector.RootPath + "/img");
		OCFileWorker.copyFile(srcFile2, destDir2,"bg38.png");
		
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCButton_Green.html";

		Html = "No" + OCStaticValue.OCid + "OCButton_Green.html";
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
