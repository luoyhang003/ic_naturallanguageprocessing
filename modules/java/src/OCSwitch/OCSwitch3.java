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
 * @author MingChao Sun ���� ��ʽ��(����ʽ)
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
		 * ��������bean
		 */
		
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");

		/*
		 * ���ļ�����
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
