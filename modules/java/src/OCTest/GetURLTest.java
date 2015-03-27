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
		 * ����SAXReader��ȡ����ר�����ڶ�ȡxml
		 */
		SAXReader saxReader = new SAXReader();
		/*
		 * ��ȡDocument���� ����ָ���ļ��ľ���·��
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
			 * ��ȡ���ڵ�
			 */
			Element root = document.getRootElement();
			/*
			 * ��ȡ���еĿؼ����
			 */
			@SuppressWarnings("unchecked")
			List<Element> widgetList = root.elements();

			/*
			 * ����Page�����Եõ����е���ҳ�еĿؼ�
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
