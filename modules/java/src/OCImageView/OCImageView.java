package OCImageView;

import java.io.File;


import OCAttribute.Attr_OCImageView;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * 插入图片使用的ImageView
 * 
 * @author MingChao Sun
 *
 */
public class OCImageView extends OCView{
	
	public Attr_OCImageView attr;

	public OCImageView(String imgURL, int height, int width) {
		super();

		this.width = width;
		this.height = height;
		

		attr = new Attr_OCImageView();

		/*
		 * 完善属性bean
		 */
		attr.setHeight(height + "px");
		attr.setWidth(width + "px");
		

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCimageView.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCimageView.html");

		File srcimg = new File(imgURL);
		
		File imgDir = new File(OCDirector.RootPath + "/img");
		
		String[] temp = imgURL.split("/");
		String name = "OCImageView" +temp[temp.length - 1];
		
		OCFileWorker.copyFile(srcimg,imgDir, name);
		
		attr.setSrcURL("../img/" + name);
		
		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCimageView.html";

		Html = "No" + OCStaticValue.OCid + "OCimageView.html";
		
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
