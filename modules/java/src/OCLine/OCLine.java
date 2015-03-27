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
		 * 完善属性bean
		 */
		
		attr.setSize(size + "px");
		attr.setWidth(width + "px");
		attr.setColor(color);

		/*
		 * 库文件复制
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

}
