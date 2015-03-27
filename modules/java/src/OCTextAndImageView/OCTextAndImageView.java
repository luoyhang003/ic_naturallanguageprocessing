package OCTextAndImageView;

import java.io.File;

import OCAttribute.Attr_OCTextAndImageView;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCTools.OCStringUtils;
import OCValue.OCStaticValue;

/**
 * 
 * @author MingChao Sun
 *
 *         OC模板——3D弹性按钮
 */
public class OCTextAndImageView extends OCView {

	public Attr_OCTextAndImageView attr;

	public OCTextAndImageView(String imgURL, String text, int imgheight,
			int textheight, int width) {
		super();

		attr = new Attr_OCTextAndImageView();

		this.width = width + OCStringUtils.dropPX(attr.getPaddingleft())
				+ OCStringUtils.dropPX(attr.getPaddingright());
		this.height = textheight + imgheight
				+ OCStringUtils.dropPX(attr.getPaddingtop())
				+ OCStringUtils.dropPX(attr.getPaddingbottom());

		/*
		 * 完善属性bean
		 */
		attr.setText(text);
		attr.setImageheight(imgheight + "px");
		attr.setTextheight(textheight + "px");
		attr.setWidth(width + "px");

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCTextImageView.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCTextImageView.html");

		File srcimg = new File(imgURL);

		File imgDir = new File(OCDirector.RootPath + "/img");

		String[] temp = imgURL.split("/");
		String name = "OCTextImageView" + temp[temp.length - 1];

		OCFileWorker.copyFile(srcimg, imgDir, name);

		attr.setImagesrc("../img/" + name);

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCTextImageView.html";

		Html = "No" + OCStaticValue.OCid + "OCTextImageView.html";

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

		this.width = OCStringUtils.dropPX(attr.getWidth())
				+ OCStringUtils.dropPX(attr.getPaddingleft())
				+ OCStringUtils.dropPX(attr.getPaddingright());
		this.height = OCStringUtils.dropPX(attr.getTextheight())
				+ OCStringUtils.dropPX(attr.getImageheight())
				+ OCStringUtils.dropPX(attr.getPaddingtop())
				+ OCStringUtils.dropPX(attr.getPaddingbottom());

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

		this.width = OCStringUtils.dropPX(attr.getWidth())
				+ OCStringUtils.dropPX(attr.getPaddingleft())
				+ OCStringUtils.dropPX(attr.getPaddingright());
		this.height = OCStringUtils.dropPX(attr.getTextheight())
				+ OCStringUtils.dropPX(attr.getImageheight())
				+ OCStringUtils.dropPX(attr.getPaddingtop())
				+ OCStringUtils.dropPX(attr.getPaddingbottom());

	}
}