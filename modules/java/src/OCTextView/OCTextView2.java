package OCTextView;

import java.io.File;

import OCAttribute.Attr_TextView1;
import OCAttribute.Attr_TextView2;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

public class OCTextView2 extends OCView{
	public Attr_TextView2 attr;
	private String text;

	public OCTextView2(String text, int height, int width) {
		super();

		this.text = changeText(text);
		this.width = width + 20;
		this.height = height + 20;
		
		attr = new Attr_TextView2();
		
		attr.setWidth(width + "px");
		attr.setHeight(height + "px");
		attr.setText(this.text);
		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCTextView2.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCTextView2.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCTextView2.html";

		Html = "No" + OCStaticValue.OCid + "OCTextView2.html";
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
		// System.out.println(attrJson);

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
