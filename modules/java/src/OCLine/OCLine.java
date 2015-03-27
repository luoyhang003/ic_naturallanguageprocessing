package OCLine;

import java.io.File;

import OCAttribute.Attr_OCLine;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

public class OCLine extends OCView{
	
	public Attr_OCLine attr;
	
	public OCLine(int size, int width,String color) {
		super();

		this.width = width;
		this.height = size;
		

		attr = new Attr_OCLine();

		/*
		 * ��������bean
		 */
		
		attr.setSize(size + "px");
		attr.setWidth(width + "px");
		attr.setColor(color);

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCLine.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCLine.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCLine.html";

		Html = "No" + OCStaticValue.OCid + "OCLine.html";
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
