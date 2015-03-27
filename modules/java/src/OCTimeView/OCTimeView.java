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
	 * ��ʾʱ��ؼ�������������
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
		 * ���ļ�����
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
