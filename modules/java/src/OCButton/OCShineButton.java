package OCButton;

import java.io.File;


import OCAttribute.Attr_ShineButton;
import OCDirector.OCDirector;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * 
 * @author MingChao Sun
 *
 *         OCģ�塪��3D���԰�ť
 */
public class OCShineButton extends OCButton {

	public Attr_ShineButton attr;

	public OCShineButton(String text, int height, int width) {
		super(text, height, width);

		this.width = width;
		this.height = height;
		this.text = text;

		attr = new Attr_ShineButton();

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
				+ "/component/OCShineButton.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCShineButton.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCShineButton.html";

		Html = "No" + OCStaticValue.OCid + "OCShineButton.html";
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
