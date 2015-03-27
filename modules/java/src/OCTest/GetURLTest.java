package OCTest;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GetURLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getWidgetNode("OCButton_Grid"));
	}
	
	public static String getWidgetNode(String widget) {
		/*
		 * 创建SAXReader读取器，专门用于读取xml
		 */
		SAXReader saxReader = new SAXReader();
		/*
		 * 获取Document对象 必须指定文件的绝对路径
		 */
		File file = new File("D://javajar/Library/xml/widget0.1.xml");
		if (!file.exists()) {
			System.out.println("not exits!!!!!");
			return null;
		}

		file.setExecutable(true);
		file.setReadable(true);
		file.setWritable(true);

		try{
			Document document = saxReader.read(file);
			/*
			 * 获取根节点
			 */
			Element root = document.getRootElement();
			/*
			 * 获取所有的控件结点
			 */
			@SuppressWarnings("unchecked")
			List<Element> widgetList = root.elements();

			/*
			 * 遍历Page结点可以得到所有的这页中的控件
			 */
			for (Object obj : widgetList) {
				Element node = (Element) obj;
				if(node.getName().equals(widget)){
					return node.asXML().trim();
				}
			}			
			
		}catch(Exception e){
			e.printStackTrace();
		}	

		return null;
	}

}
