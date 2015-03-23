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
 * 生成XML格式的语料
 * @author Luo Yuanhang
 *
 */
public class BUILDXMLDOC {
	/**
	 * 创建XML文档
	 * @param fileName
	 * @param targetName
	 * @throws Exception
	 */
	public static void build(String fileName, String targetName) throws Exception{
		//对文档进行分词
		String result[] = NLPIR.Segment(fileName);
		//获取分词结果
		String sourceString = result[0];
		//获取关键词
		String keyWord = result[1];
		
		//建立XML文档
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement(fileName);
		Element ele_text = root.addElement("text");
		Element ele_texthead = ele_text.addElement("text_head");
		ele_texthead.addAttribute("subject", "主题");
		ele_texthead.addAttribute("source", "path");
		Element ele_keywords = ele_text.addElement("text_keywords");
		ele_keywords.addAttribute("content", keyWord);
		Element ele_textbody = ele_text.addElement("text_body");
		Element ele_para = ele_textbody.addElement("para");
		ele_para.addAttribute("pid", "1");
		
		//去除标点词性标注
		for(int i = 0; i < SYMBOL.PUNC_CODE.length;i++){
			sourceString = sourceString.replaceAll(SYMBOL.PUNC_CODE[i],"");
		}
		//利用表达式去除标点的词性标注
		String[] sentences = sourceString.split("\\?+|\\.+|\\!+|\\？+|\\。+|\\！");
		//分句
		for(int i = 0; i < sentences.length - 1; i++){
			//动态添加元素
			Element ele_s = ele_para.addElement("s").addAttribute("sid",""+(i+1)).addText(cutWordsAndPure(sentences[i]));

		}
		//将XML输出到文件
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
	 * 读取XML文档
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
	 * 切分词语并去除无意义的词
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
	 * 遍历xml节点
	 * @param node
	 */
	private static void listNodes(Element node){
		System.out.println("Nodename:"+node.getName());
		//获取当前节点的属性节点
		List<Attribute> list = node.attributes();
		//遍历属性节点
		for(Attribute attr:list){
			System.out.println(attr.getText()+"----"+attr.getName()+"----"+attr.getValue());
		}
		
		if(!(node.getTextTrim().equals(""))){
			System.out.println("content::::"+node.getText());
		}
		
		Iterator<Element> it = node.elementIterator();
		//遍历
		while(it.hasNext()){
			//获取某个子节点对象
			Element e = it.next();
			//对子节点进行遍历
			listNodes(e);
		}
		
	}
	
	/**
	 * 净化分词结果，去除一些无意义的词
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








