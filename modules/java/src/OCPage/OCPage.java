package OCPage;

import java.io.File;

import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCStringUtils;
import OCValue.OCStaticValue;

/**
 * 页面类
 * 
 * @author MingChao Sun
 * 
 */
public class OCPage {

	/**
	 * 本地类型
	 */
	public static int OCPageType_LOCAL = 0;

	/**
	 * 外部网站类型
	 */
	public static int OCPageType_Web = 1;

	/**
	 * 图片背景类型
	 */
	public static int OCPageBgType_Img = 0;

	/**
	 * 纯色背景类型
	 */
	public static int OCPageBgType_Color = 1;

	/**
	 * 页面类型
	 */
	private int Type;

	/**
	 * 页面名称
	 */
	private String name;

	/**
	 * 页面路径
	 */
	private String Path;

	/**
	 * 页面id
	 */
	private int id;

	/**
	 * 是否是初始页面
	 */
	private boolean isIndex = false;

	/**
	 * 构造方法 生成文件 同时生成路径 设置name为标题
	 * 
	 * @param Type
	 * @param NameOrPath
	 */
	public OCPage(int Type, String NameOrPath) {

		this.Type = Type;
		this.name = NameOrPath;

		/*
		 * 本地网页
		 */
		if (Type == 0) {

			Path = OCDirector.RootPath + "/" + name + ".html";

			File srcFile = new File(OCStaticValue.LibraryURl + "/index.html");
			System.out.println(OCDirector.RootPath);
			File destDir = new File(OCDirector.RootPath);
			OCFileWorker.copyFile(srcFile, destDir, name + ".html");

			OCHtmlWorker.setPageTitle(Path, name);

		} else {
			Path = NameOrPath;
		}
	}

	/**
	 * 为页面设置背景的方法
	 * 
	 * @param Type
	 * @param setting
	 */
	public void setbackground(int Type, String setting) {

		String changedJson = OCHtmlWorker
				.setPagebackground(Type, Path, setting);

		OCHtmlWorker.ChangeJsonblock(Path, changedJson);

	}

	/**
	 * 添加view到页面的方法
	 * 
	 * @param view
	 * @param x
	 * @param y
	 */
	public void add(OCView view, int x, int y) {

		String Ifream = "<div style=\"position: absolute;left: "
				+ x
				+ "px;top: "
				+ y
				+ "px; \"><iframe scrolling=\"no\" width=\""
				+ 1.2
				* (view.width + 3)
				+ "\"  frameborder=\"0\" allowtransparency=\"true\" src=\""
				+ "component/"
				+ view.Html
				+ "\" id=\"ifm\" onload=\"javascript:dyniframesize('ifm')\"></iframe></div>";

		OCHtmlWorker.innerHtml(Path, "body", Ifream);

	}

	/**
	 * 添加view到页面的方法(带有margin)
	 * 
	 * @param view
	 * @param x
	 * @param y
	 */
	public void add(OCView view, int x, int y, int margin) {

		String Ifream = "<div style=\"position: absolute;left: "
				+ x
				+ "px;top: "
				+ y
				+ "px; \"><iframe scrolling=\"no\" width=\""
				+ 1.2
				* (view.width + 3 + margin)
				+ "\"  frameborder=\"0\" allowtransparency=\"true\" src=\""
				+ "component/"
				+ view.Html
				+ "\" id=\"ifm\" onload=\"javascript:dyniframesize('ifm')\"></iframe></div>";

		OCHtmlWorker.innerHtml(Path, "body", Ifream);

	}

	/**
	 * 添加view到页面的方法(带有margin)
	 * 
	 * @param view
	 * @param x
	 * @param y
	 */
	public void add(OCView view, int x, int y, int marginx, int marginy) {

		String Ifream = "<div style=\"position: absolute;left: " + x
				+ "px;top: " + y + "px; \"><iframe scrolling=\"no\" width=\""
				+ (view.width + marginx) + "\" height=\""
				+ (view.height + marginy)
				+ "\" allowtransparency=\"true\" src=\"" + "component/"
				+ view.Html + "\"  frameborder=\"0\"></iframe></div>";

		OCHtmlWorker.innerHtml(Path, "body", Ifream);

	}

	public void add(OCView view, int x, int y, String marginxstr,
			String marginystr) {

		int marginx = OCStringUtils.dropPX(marginxstr) * 2;
		int marginy = OCStringUtils.dropPX(marginystr) * 2;
		String Ifream = "<div style=\"position: absolute;left: " + x
				+ "px;top: " + y + "px; \"><iframe scrolling=\"no\" width=\""
				+ (view.width + marginx) + "\" height=\""
				+ (view.height + marginy)
				+ "\" allowtransparency=\"true\" src=\"" + "component/"
				+ view.Html + "\"  frameborder=\"0\"></iframe></div>";

		OCHtmlWorker.innerHtml(Path, "body", Ifream);

	}

	/*
	 * get set 方法
	 */

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public boolean isIndex() {
		return isIndex;
	}

	public void setIndex(boolean isIndex) {
		this.isIndex = isIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
