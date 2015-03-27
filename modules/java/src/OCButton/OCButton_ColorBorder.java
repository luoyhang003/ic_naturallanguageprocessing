package OCButton;

import java.io.File;


import OCAttribute.Attr_Button_ColorBorder;
import OCDirector.OCDirector;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * 边框有颜色，内部是白色的边框
 * @author xing
 *
 */
public class OCButton_ColorBorder extends OCButton {

	public Attr_Button_ColorBorder attr;

	public OCButton_ColorBorder(String text, int height, int width) {
		super(text, height, width);

		this.width = width;
		this.height = height;
		this.text = changeText(text);

		attr = new Attr_Button_ColorBorder();

		/*
		 * 完善属性bean
		 */
		attr.setText(this.text);
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCButton_ColorBorder.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCButton_ColorBorder.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCButton_ColorBorder.html";

		Html = "No" + OCStaticValue.OCid + "OCButton_ColorBorder.html";
		OCStaticValue.OCid++;
		/*
		 * 生成json
		 */
		attrJson = OCJsonWorker.BeanToJson(attr);

		/*
		 * 替换json
		 */
		OCHtmlWorker.ChangeJsonblock(Path, attrJson);
	}

	public void setAttr(Object attrbean) {

		/*
		 * 生成json
		 */
		attrJson = OCJsonWorker.BeanToJson(attrbean);

		/*
		 * 替换json
		 */
		OCHtmlWorker.ChangeJsonblock(Path, attrJson);
	}

	public void setAttr() {
		/*
		 * 生成json
		 */
		attrJson = OCJsonWorker.BeanToJson(attr);

		/*
		 * 替换json
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
