package OCTimeView;

import java.io.File;
import OCAttribute.Attr_TimeView;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

public class OCTimeView extends OCView {
	/**
	 * 显示时间控件的属性设置器
	 */
	public Attr_TimeView attr;

	public OCTimeView(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		attr = new Attr_TimeView();
		attr.setWidth(width + "px");
		attr.setHeight(height + "px");
		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCTimeView.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCTimeView.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCTimeView.html";

		Html = "No" + OCStaticValue.OCid + "OCTimeView.html";
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
