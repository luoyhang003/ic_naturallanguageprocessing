package OCImageSwitch;

import java.io.File;
import java.util.Vector;

import OCAttribute.Attr_OCImageSwitch1;
import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;
import OCValue.OCStaticValue;

/**
 * 
 * 相册空间一
 * 
 * @author MingChao Sun
 *
 */
public class OCImageSwitch1 extends OCView {

	public Attr_OCImageSwitch1 attr;

	/**
	 * 图片路径1
	 */
	String img1;

	/**
	 * 图片路径2
	 */
	String img2;

	/**
	 * 图片路径3
	 */
	String img3;

	/**
	 * 图片路径3
	 */
	String img4;

	public OCImageSwitch1(int height, int width, String img1, String img2,
			String img3, String img4) {
		super();

		attr = new Attr_OCImageSwitch1();

		this.width = width;
		this.height = height;

		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCImageSwitch1.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCImageSwitch1.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCImageSwitch1.html";

		Html = "No" + OCStaticValue.OCid + "OCImageSwitch1.html";

		File imgFile1 = new File(img1);
		File imgFile2 = new File(img2);
		File imgFile3 = new File(img3);
		File imgFile4 = new File(img4);

		File Dir = new File(OCDirector.RootPath + "/img");

		String[] temp1 = img1.split("/");
		String name1 = "OCImageSwitch1" +temp1[temp1.length - 1];
		OCFileWorker.copyFile(imgFile1, Dir, name1);

		String[] temp2 = img2.split("/");
		String name2 = "OCImageSwitch1" +temp2[temp2.length - 1];
		OCFileWorker.copyFile(imgFile2, Dir, name2);

		String[] temp3 = img3.split("/");
		String name3 = "OCImageSwitch1" +temp3[temp3.length - 1];
		OCFileWorker.copyFile(imgFile3, Dir, name3);

		String[] temp4 = img4.split("/");
		String name4 = "OCImageSwitch1" +temp4[temp4.length - 1];
		OCFileWorker.copyFile(imgFile4, Dir, name4);

		img1 = "../img/" + name1;
		img2 = "../img/" + name2;
		img3 = "../img/" + name3;
		img4 = "../img/" + name4;

		OCStaticValue.OCid++;

		SetAttrs(height, width, img1, img2, img3, img4);

	}

	private void SetAttrs(int height, int width, String img1, String img2,
			String img3, String img4) {

		String CSSSource = OCHtmlWorker.getMyCSS(Path);

		String result = "";

		String parts[] = CSSSource.split("@@1");

		Vector<String> attrs = new Vector<String>();

		attrs.add(width + "px");
		attrs.add(height + "px");
		attrs.add(width / 4 + "px");
		attrs.add(7 * height / 8 + "px");
		attrs.add(width + "px");
		attrs.add(height + "px");
		attrs.add(width / 4 + "px");
		attrs.add(img1);
		attrs.add(img2);
		attrs.add(img3);
		attrs.add(img4);
		attrs.add((-0) * width / 4 + "px");
		attrs.add((-1) * width / 4 + "px");
		attrs.add((-2) * width / 4 + "px");
		attrs.add((-3) * width / 4 + "px");
		attrs.add(7 * height / 8 + "px");

		for (int i = 0; i < attrs.size(); i++) {

			result = result + parts[i] + attrs.get(i);

		}

		result = result + parts[parts.length - 1];

		OCHtmlWorker.ChangeCSSblock(Path, result);
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
