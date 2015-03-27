package OCButton;

import java.io.File;

import OCAttribute.Attr_Button_Flat;
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
public class OCButton_Flat extends OCButton {

	public Attr_Button_Flat attr;

	public OCButton_Flat(String text,int height, int width) {
		super("text",height, width);

		this.width = width;
		this.height = height;
		this.text = changeText(text);

		attr = new Attr_Button_Flat();

		/*
		 * ��������bean
		 */
		attr.setWidth(width + "px");
		attr.setHeight(height + "px");
		attr.setText(this.text);	

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCButton_Flat.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCButton_Flat.html");
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCButton_Flat.html";

		Html = "No" + OCStaticValue.OCid + "OCButton_Flat.html";
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
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	private String changeText(String text) {
		char strArray[] = text.toCharArray();
		String result = "";
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i] == ' ') {
				result += "@@";
			} else {
				result += strArray[i];
			}
		}

		return result;
	}

}
