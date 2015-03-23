package com.luoyuanhang.imaginecup.segment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;


/**
 * ����XML��ʽ������
 * @author Luo Yuanhang
 *
 */
public class BUILDXMLDOC {
	/**
	 * ����XML�ĵ�
	 * @param fileName
	 * @param targetName
	 * @throws Exception
	 */
	public static void build(String fileName, String targetName) throws Exception{
		//���ĵ����зִ�
		String result[] = NLPIR.Segment(fileName);
		//��ȡ�ִʽ��
		String sourceString = result[0];
		//��ȡ�ؼ���
		String keyWord = result[1];
		
		//����XML�ĵ�
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement(fileName);
		Element ele_text = root.addElement("text");
		Element ele_texthead = ele_text.addElement("text_head");
		ele_texthead.addAttribute("subject", "����");
		ele_texthead.addAttribute("source", "path");
		Element ele_keywords = ele_text.addElement("text_keywords");
		ele_keywords.addAttribute("content", keyWord);
		Element ele_textbody = ele_text.addElement("text_body");
		Element ele_para = ele_textbody.addElement("para");
		ele_para.addAttribute("pid", "1");
		
		//ȥ�������Ա�ע
		for(int i = 0; i < SYMBOL.PUNC_CODE.length;i++){
			sourceString = sourceString.replaceAll(SYMBOL.PUNC_CODE[i],"");
		}
		//���ñ��ʽȥ�����Ĵ��Ա�ע
		String[] sentences = sourceString.split("\\?+|\\.+|\\!+|\\��+|\\��+|\\��");
		//�־�
		for(int i = 0; i < sentences.length - 1; i++){
			//��̬���Ԫ��
			Element ele_s = ele_para.addElement("s").addAttribute("sid",""+(i+1)).addText(cutWordsAndPure(sentences[i]));

		}
		//��XML������ļ�
		try{
			FileOutputStream out = new FileOutputStream("./xml/test.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter writer = new XMLWriter(out, format);
			writer.write(document);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡXML�ĵ�
	 * @param fileName
	 * @throws DocumentException 
	 */
	public static void readXml(String fileName) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read("xml/"+fileName);
		Element node = document.getRootElement();
		listNodes(node);
	}
	
	/**
	 * �зִ��ﲢȥ��������Ĵ�
	 * @param input
	 */
	private static String cutWordsAndPure(String input){
		String words[] = input.split(" ");
		String output = "";
		for(int i = 0; i < words.length; i++){
			for(int j = 0; j < SYMBOL.POS_USELESS.length; j++){
				if(words[i].contains(SYMBOL.POS_USELESS[j])){
					words[i]="";
				}
			}
		}
		for(int i = 0; i < words.length; i++){
			output += words[i] + " ";
		}
		return output;
	}
	
	/**
	 * ����xml�ڵ�
	 * @param node
	 */
	private static void listNodes(Element node){
		System.out.println("Nodename:"+node.getName());
		//��ȡ��ǰ�ڵ�����Խڵ�
		List<Attribute> list = node.attributes();
		//�������Խڵ�
		for(Attribute attr:list){
			System.out.println(attr.getText()+"----"+attr.getName()+"----"+attr.getValue());
		}
		
		if(!(node.getTextTrim().equals(""))){
			System.out.println("content::::"+node.getText());
		}
		
		Iterator<Element> it = node.elementIterator();
		//����
		while(it.hasNext()){
			//��ȡĳ���ӽڵ����
			Element e = it.next();
			//���ӽڵ���б���
			listNodes(e);
		}
		
	}
	
	/**
	 * �����ִʽ����ȥ��һЩ������Ĵ�
	 * @param filename
	 */
	public static void pureDoc(String fileName) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read("xml/"+fileName);
		Element root = document.getRootElement();
		Element text = root.element("text");
		Element body = text.element("text_body");
		Element para = body.element("para");
		List<Element> nodes = para.elements("s");
		for(Iterator<Element> it = nodes.iterator();it.hasNext();){
			Element element = (Element)it.next();
			String input = element.getText();
			String output = cutWordsAndPure(input);
			System.out.println(output);
		}

	}
	
}








