package OCSwitch;

import java.io.File;


import OCAttribute.Attr_OCSwitch3;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * 
 * @author MingChao Sun 开关 样式三(立体式)
 *
 */
public class OCSwitch3 extends OCView{
	
	public Attr_OCSwitch3 attr;

	public OCSwitch3(int height, int width) {
		super();

		this.width = width;
		this.height = height;
		

		attr = new Attr_OCSwitch3();

		/*
		 * 完善属性bean
		 */
		
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCSwitch3.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCSwitch3.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCSwitch3.html";

		Html = "No" + OCStaticValue.OCid + "OCSwitch3.html";
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
