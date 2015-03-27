package OCTools;

import OCAttribute.Attr_Download_URL;
import OCTools.OCHtmlWorker;
import OCTools.OCJsonWorker;

/**
 * 
 * @author MingChao Sun
 * 
 *         OC模板——3D弹性按钮
 */
public class OCDownload {

	public Attr_Download_URL attr;
	private String attrJson;
	private String Path;

	public OCDownload(String urlString) {

		attr = new Attr_Download_URL();

		/*
		 * 完善属性bean
		 */
		attr.setUrlString(urlString);
		/*
		 * 生成json
		 */
		attrJson = OCJsonWorker.BeanToJson(attr);
		Path = "C://OfficeCoder/DownloadHTML/index.html";

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
