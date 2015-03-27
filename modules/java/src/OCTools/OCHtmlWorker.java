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
 *         �������ڽ�����HTML����
 */
public class OCHtmlWorker {

	/**
	 * ��html �ļ� ��� ��document
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
	 * ��ѡ��ı�ǩ��ע��html(������)
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
	 * ��ѡ��ı�ǩ��ע��html(����)
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
	 * ������html�ļ����ڱ������
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
	 * Ϊҳ�����ñ���
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
	 * ��html�ļ��л�ȡĿǰcss����
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
	 * ��json����ֱ���滻������json�ķ���
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
	 * ��html�ļ��л�ȡĿǰjson����
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
	 * ����ҳ�汳���ķ������д�ɫ��ͼƬ����
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

		// ��Javabeanת��ΪJson���ݣ���ҪMap��ת��
		JSONObject jo1 = OCJsonWorker.toJSON(attr_page);

		// System.out.println(jo1.toString());

		changejson = jo1.toString();

		return changejson;

	}

	/**
	 * ��json����ֱ���滻������json�ķ���
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
	 * ɾ���п��ܻᷢ����ͻ��document��ֵ����
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
