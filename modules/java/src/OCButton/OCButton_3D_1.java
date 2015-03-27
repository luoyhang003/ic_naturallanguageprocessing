package OCButton;

import java.io.File;

import OCAttribute.Attr_Button_3D_1;
import OCDirector.OCDirector;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * 
 * @author MingChao Sun
 *
 *         OC模板——3D弹性按钮
 */
public class OCButton_3D_1 extends OCButton {

	public Attr_Button_3D_1 attr;

	public OCButton_3D_1(String text, int height, int width) {
		super(text, height, width);

		this.width = width;
		this.height = height;
		this.text = text;

		attr = new Attr_Button_3D_1();

		/*
		 * 完善属性bean
		 */
		attr.setText(text);
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCbutton_3D_1.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCbutton_3D_1.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCbutton_3D_1.html";

		Html = "No" + OCStaticValue.OCid + "OCbutton_3D_1.html";
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
