package OCTools;

import OCAttribute.Attr_Download_URL;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;

/**
 * 
 * @author MingChao Sun
 * 
 *         OCģ�塪��3D���԰�ť
 */
public class OCDownload {

	public Attr_Download_URL attr;
	private String attrJson;
	private String Path;

	public OCDownload(String urlString) {

		attr = new Attr_Download_URL();

		/*
		 * ��������bean
		 */
		attr.setUrlString(urlString);
		/*
		 * ����json
		 */
		attrJson = OCJsonWorker.BeanToJson(attr);
		Path = "C://OfficeCoder/DownloadHTML/index.html";

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
