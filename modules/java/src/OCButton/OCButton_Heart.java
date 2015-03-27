package OCButton;

import java.io.File;



import OCAttribute.Attr_Button_Heart;
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
public class OCButton_Heart extends OCButton {

	public Attr_Button_Heart attr;

	public OCButton_Heart(int height, int width) {
		super("",height, width);

		this.width = width;
		this.height = height;

		attr = new Attr_Button_Heart();

		/*
		 * ��������bean
		 */
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");
		
		/*
		 * ���ݰ�ť�Ĵ�С��ȷ��ͼƬ�Ĵ�С
		 */
		int min = height<width?height:width;
		attr.setBgheight(Integer.toString((int)(min*0.8))+ "px");
		attr.setBgwidth(Integer.toString((int)(min*0.8))+ "px");
		
		/*
		 * ���ݰ�ť�Ĵ�С��ȷ����ť��λ��
		 */
		attr.setDisleft(Integer.toString((int)(width-min*0.8)/2)+ "px");
		attr.setDistop(Integer.toString((int)(height-min*0.8)/2)+ "px");
		

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCButton_Heart.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCButton_Heart.html");
		
		File srcFile2 = new File(OCStaticValue.LibraryURl
				+ "/img/heart.png");
		File destDir2 = new File(OCDirector.RootPath + "/img");
		OCFileWorker.copyFile(srcFile2, destDir2,"heart.png");
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCButton_Heart.html";

		Html = "No" + OCStaticValue.OCid + "OCButton_Heart.html";
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
	 * ��̬�޸Ŀռ����״
	 * 
	 * @param mode
	 */
	public void setMode(int shapemode) {
		attr.setShapemode(shapemode);
		int intHeight = Integer.parseInt(attr.getHeight().substring(0,
				attr.getHeight().length() - 2));
		int intWidth = Integer.parseInt(attr.getWidth().substring(0,
				attr.getWidth().length() - 2));
		int min = 0;
		if (intHeight < intWidth)
			min = intHeight;
		else
			min = intWidth;

		/*
		 * ���ݰ�ť�Ĵ�С��ȷ��ͼƬ�Ĵ�С
		 */
		attr.setBgheight(Integer.toString((int) (min * 0.8)) + "px");
		attr.setBgwidth(Integer.toString((int) (min * 0.8)) + "px");

		/*
		 * ���ݰ�ť�Ĵ�С��ȷ����ť��λ��
		 */

		if (shapemode == 1) {
			attr.setDisleft(Integer.toString((int) (intWidth - min * 0.8) / 2)
					+ "px");
			attr.setDistop(Integer.toString((int) (intHeight - min * 0.8) / 2)
					+ "px");
		} else if (shapemode == 2) {
			attr.setHeight(min + "px");
			attr.setWidth(min + "px");
			this.height = min;
			this.width = min;
			attr.setDisleft(Integer.toString((int) (min * 0.1)) + "px");
			attr.setDistop(Integer.toString((int) (min * 0.1)) + "px");
		} else if (shapemode == 3) {
			attr.setHeight(min + "px");
			attr.setWidth(min + "px");
			this.height = min;
			this.width = min;
			attr.setDisleft(Integer.toString((int) (min * 0.1)) + "px");
			attr.setDistop(Integer.toString((int) (min * 0.1)) + "px");
			attr.setMargin((int) ((min / 4) * 1.141) + "px");
		}
	}

}