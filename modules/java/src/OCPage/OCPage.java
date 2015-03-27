package OCPage;

import java.io.File;

import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCTools.OCStringUtils;
import OCValue.OCStaticValue;

/**
 * ҳ����
 * 
 * @author MingChao Sun
 * 
 */
public class OCPage {

	/**
	 * ��������
	 */
	public static int OCPageType_LOCAL = 0;

	/**
	 * �ⲿ��վ����
	 */
	public static int OCPageType_Web = 1;

	/**
	 * ͼƬ��������
	 */
	public static int OCPageBgType_Img = 0;

	/**
	 * ��ɫ��������
	 */
	public static int OCPageBgType_Color = 1;

	/**
	 * ҳ������
	 */
	private int Type;

	/**
	 * ҳ������
	 */
	private String name;

	/**
	 * ҳ��·��
	 */
	private String Path;

	/**
	 * ҳ��id
	 */
	private int id;

	/**
	 * �Ƿ��ǳ�ʼҳ��
	 */
	private boolean isIndex = false;

	/**
	 * ���췽�� �����ļ� ͬʱ����·�� ����nameΪ����
	 * 
	 * @param Type
	 * @param NameOrPath
	 */
	public OCPage(int Type, String NameOrPath) {

		this.Type = Type;
		this.name = NameOrPath;

		/*
		 * ������ҳ
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
	 * Ϊҳ�����ñ����ķ���
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
	 * ���view��ҳ��ķ���
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
	 * ���view��ҳ��ķ���(����margin)
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
	 * ���view��ҳ��ķ���(����margin)
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
	 * get set ����
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
