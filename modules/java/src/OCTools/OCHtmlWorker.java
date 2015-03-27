package OCTools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import OCAttribute.Attr_Page;
import OCDirector.OCDirector;
import OCPage.OCPage;

/**
 * 
 * @author MingChao Sun
 *
 *         该类用于解析与HTML设置
 */
public class OCHtmlWorker {

	/**
	 * 从html 文件 获得 其document
	 * 
	 * @param HtmlPath
	 * @return Document
	 */
	private static Element getDocumentfromHtml(String HtmlPath) {

		File input = new File(HtmlPath);
		Document doc = null;

		try {
			doc = Jsoup.parse(input, "UTF-8", "");
		} catch (IOException e) {

			e.printStackTrace();
		}

		return doc;

	}

	/**
	 * 向选择的标签中注入html(向后添加)
	 * 
	 * @param HtmlPath
	 * @param title
	 */
	public static void innerHtml(String HtmlPath, String selectSign,
			String innerHtml) {

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements Part = document.select(selectSign);
		Part.append(innerHtml);

		SaveFile(HtmlPath, document);

	}

	/**
	 * 向选择的标签中注入html(覆盖)
	 * 
	 * @param HtmlPath
	 * @param title
	 */
	public static void changeHtml(String HtmlPath, String selectSign,
			String innerHtml) {

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements Part = document.select(selectSign);
		Part.html(innerHtml);

		SaveFile(HtmlPath, document);

	}

	/**
	 * 更改完html文件用于保存更改
	 * 
	 * @param HtmlPath
	 * @param document
	 */
	private static void SaveFile(String HtmlPath, Document document) {

		File input = new File(HtmlPath);

		FileOutputStream fos;
		OutputStreamWriter osw;

		try {
			fos = new FileOutputStream(input, false);
			osw = new OutputStreamWriter(fos, "UTF-8");
			String str = document.html();
			str = str.replaceAll("@@", "&nbsp");
			// System.out.println(str);
			osw.write(str);
			osw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 为页面设置标题
	 * 
	 * @param HtmlPath
	 * @param title
	 */
	public static void setPageTitle(String HtmlPath, String title) {

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements Title = document.select("title");
		Title.html(title);

		SaveFile(HtmlPath, document);

	}

	/**
	 * 从html文件中获取目前css部分
	 * 
	 * @param HtmlPath
	 * @return
	 */
	public static String getMyCSS(String HtmlPath) {

		String MyCSS = "";

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements jsonElement = document.select("#mcss");

		String elementToString = jsonElement.html();

		// System.out.println(elementToString);

		MyCSS = elementToString;

		return MyCSS;
	}

	/**
	 * 将json部分直接替换成已有json的方法
	 * 
	 * @param HtmlPath
	 * @param changedJson
	 */
	@SuppressWarnings("unused")
	public static void ChangeCSSblock(String HtmlPath, String changedCSS) {

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements jsonElement = document.select("#mcss");

		String elementToString = jsonElement.html();

		// System.out.println(jsonElement.html());

		jsonElement.html(changedCSS);

		SaveFile(HtmlPath, document);

	}

	/**
	 * 从html文件中获取目前json部分
	 * 
	 * @param HtmlPath
	 * @return
	 */
	public static String getMyJson(String HtmlPath) {

		String MyJson = "";

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements jsonElement = document.select("#mjson");

		String elementToString = jsonElement.html();

		// System.out.println(elementToString);

		String[] temp = elementToString.split("};");

		temp = temp[0].split("=");

		String JSONSource = temp[1] + "}";

		// System.out.println(JSONSource);

		MyJson = OCJSONForMater.format(JSONSource);

		return MyJson;
	}

	/**
	 * 设置页面背景的方法，有纯色与图片两种
	 * 
	 * @param Type
	 * @param HtmlPath
	 * @param setting
	 * @return
	 */
	public static String setPagebackground(int Type, String HtmlPath,
			String setting) {

		String changejson;

		Attr_Page attr_page = new Attr_Page();

		if (Type == OCPage.OCPageBgType_Color) {

			attr_page.setBackgroundcolor(setting);

			OCHtmlWorker.DeleteAttrSetter(HtmlPath, "background");

		} else if (Type == OCPage.OCPageBgType_Img) {

			File srcFile1 = new File(setting);
			File destDir = new File(OCDirector.RootPath + "/img");
			String[] temp = setting.split("/");
			String name = temp[temp.length - 1];
			OCFileWorker.copyFile(srcFile1, destDir, name);

			attr_page.setBackgroundimg("img/" + name);
		}

		// 将Javabean转换为Json数据（需要Map中转）
		JSONObject jo1 = OCJsonWorker.toJSON(attr_page);

		// System.out.println(jo1.toString());

		changejson = jo1.toString();

		return changejson;

	}

	/**
	 * 将json部分直接替换成已有json的方法
	 * 
	 * @param HtmlPath
	 * @param changedJson
	 */
	public static void ChangeJsonblock(String HtmlPath, String changedJson) {

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements jsonElement = document.select("#mjson");

		String elementToString = jsonElement.html();

		// System.out.println(jsonElement.html());

		String[] temp1 = elementToString.split("};");

		String[] temp2 = temp1[0].split("=");

		temp2[1] = changedJson;

		String result = temp2[0] + "=" + temp2[1] + ";" + temp1[1];

		// System.out.println(result);

		jsonElement.html(result);

		SaveFile(HtmlPath, document);

	}

	/**
	 * 删除有可能会发生冲突的document赋值方法
	 * 
	 * @param HtmlPath
	 * @param deleteAttrSetter
	 */
	public static void DeleteAttrSetter(String HtmlPath, String deleteAttrSetter) {

		Document document = (Document) getDocumentfromHtml(HtmlPath);

		Elements jsonElement = document.select("#mjson");

		String elementToString = jsonElement.html();

		// System.out.println(elementToString);

		String[] temp1 = elementToString.split(";");

		for (int i = 1; i < temp1.length - 1; i++) {

			String[] temp2 = temp1[i].split("style.");

			String[] sign = temp2[1].split(" =");

			if (sign[0].equals(deleteAttrSetter)) {
				elementToString = "";
				for (int j = 0; j < temp1.length - 1; j++) {
					if (j == i) {
						continue;
					}

					elementToString += (temp1[j] + ";");
				}

				elementToString += "}";
			}
		}

		// System.out.println(elementToString);
		jsonElement.html(elementToString);

		SaveFile(HtmlPath, document);

	}
}
