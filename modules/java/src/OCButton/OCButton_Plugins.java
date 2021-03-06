package OCButton;

import java.io.File;



import OCAttribute.Attr_Button_Plugins;
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
public class OCButton_Plugins extends OCButton {

	public Attr_Button_Plugins attr;

	public OCButton_Plugins(int height, int width) {
		super("",height, width);

		this.width = width;
		this.height = height;

		attr = new Attr_Button_Plugins();

		/*
		 * 完善属性bean
		 */
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");
		
		/*
		 * 根据按钮的大小来确定图片的大小
		 */
		int min = height<width?height:width;
		attr.setBgheight(Integer.toString((int)(min*0.8))+ "px");
		attr.setBgwidth(Integer.toString((int)(min*0.8))+ "px");
		
		/*
		 * 根据按钮的大小来确定按钮的位置
		 */
		attr.setDisleft(Integer.toString((int)(width-min*0.8)/2)+ "px");
		attr.setDistop(Integer.toString((int)(height-min*0.8)/2)+ "px");
		

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCButton_Plugins.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCButton_Plugins.html");
		
		File srcFile2 = new File(OCStaticValue.LibraryURl
				+ "/img/plugins.png");
		File destDir2 = new File(OCDirector.RootPath + "/img");
		OCFileWorker.copyFile(srcFile2, destDir2,"plugins.png");
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCButton_Plugins.html";

		Html = "No" + OCStaticValue.OCid + "OCButton_Plugins.html";
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
	 * 动态修改空间的形状
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
		 * 根据按钮的大小来确定图片的大小
		 */
		attr.setBgheight(Integer.toString((int) (min * 0.8)) + "px");
		attr.setBgwidth(Integer.toString((int) (min * 0.8)) + "px");

		/*
		 * 根据按钮的大小来确定按钮的位置
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
