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


//码/v 农/ng 顾名思义/vl 为/p 编码/n 的/ude1 农民/n ，/wd 尤其/d 是/vshi 在/p 工业化/vn 迅速/ad 发展/v 的/ude1 今天/t ，/wd 各行各业/nl 对/p 计算机/n 应用/vn 的/ude1 依赖/vn 不断/d 增强/v ，/wd 随之而来/vl 的/ude1 社会/n 需求/n 大量/m 的/ude1 IT/rzt 民工/n 投入/v 到/v 基础/n 的/ude1 编码/n 工作/vn 当中/f 来/vf ，/wd 他们/rr 有着/v 聪慧/a 的/ude1 大脑/n ，/wd 对于/p 编程/vn ，/wd 设计/v ，/wd 开发/v ，/wd 有着/v 熟练/a 的/ude1 技巧/n ，/wd 但/c 随着/p 企业/n 雇主/n 的/ude1 对/p 利润/n 的/ude1 不断/d 追求/v ，/wd 他们/rr 的/ude1 生活/vn 时间/n 是/vshi 相当/vi 的/ude1 紧/a ，/wd 加班/vi 对于/p 他们/rr 来说/uls 很/d 正常/a ，/wd 于是/cc 对应/vn 建筑/n 行业/n 的/ude1 农民工/n ，/wd 他们/rr 的/ude1 地位/n 相比/vi 与/p 农民工/n 相比/vi 是/vshi 优越/a 了/ule 许多/m ，/wd 人类/n 已经/d 开始/v 逐渐/d 从/p 体力/n 劳动/vi 向/p 抽象/a 劳动/vn 转变/vn ，/wd 但/c 高/a 强度/n 的/ude1 劳动/vn 与/cc 他们/rr 投入/v 劳动/vn 所/usuo 获得/v 的/ude1 回报/vn 在/p 有些/rz 场合/n 却/d 不/d 相称/a ，/wd 业内人士/n 习惯/n 把/pba 专注/vi 于/p 程序/n 设计/vn 工作/vn 的/ude1 人/n 称为/v 码/v 农/ng 。/wj 当时/t 为了/p 数据/n 的/ude1 可/c 移植/v 性/ng 我/rr 放弃/v 了/ule 使用/vn 数据库/n ，/wd 将/p 全部/m 数据/n 保存/v 为/v UTF/n －/wp 8/m 编码/n 的/ude1 文本/n 文件/n ，/wd 读取/v 这种/r 文件/n 秩序/n 只要/c 指定/v 打开/v 文件/n 的/ude1 编码/n 方式/n ，/wd 中文/nz 问题/n 就/d 可以/v 避免/v 。/wj 但是/c 按照/p 我/rr 以前/f 的/ude1 思维/n ，/wd java/nz 中/f 不/d 是/vshi 这么/rz 作/v 的/ude1 ，/wd java/nz 中/f 都/d 是/vshi 先/d 读取/v 后/f 转换/v 的/ude1 ，/wd 最后/f 的/ude1 结果/n 证明/v 我/rr 错/v 了/y ，/wd 看来/v 经验/n 主意/n 害/v 死人/n 呀/y 。/wj 

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
		
//		sourceString =cutWordsAndPure(sourceString);
		
		for(int i = 0; i < SYMBOL.PUNC_CODE.length;i++){
			sourceString = sourceString.replaceAll(SYMBOL.PUNC_CODE[i],"");
		}
		//利用表达式去除标点的词性标注
		String[] sentences = sourceString.split("\\?+|\\.+|\\!+|\\？+|\\。+|\\！");
		//分句
		for(int i = 0; i < sentences.length - 1; i++){
			//动态添加元素
			Element ele_s = ele_para.addElement("s").addAttribute("sid",""+(i+1)).addText(cutWordsAndPure(sentences[i]));
//			Element ele_s = ele_para.addElement("s").addAttribute("sid",""+(i+1)).addText(sentences[i]);

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
			output += words[i];
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








