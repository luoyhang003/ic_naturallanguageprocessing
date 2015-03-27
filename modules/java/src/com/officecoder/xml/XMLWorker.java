package com.officecoder.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml源文件的创建和操作
 * 
 * @author xing
 * 
 */
public class XMLWorker {

	/**
	 * 源文件的绝对路径名称
	 */
	private String fileName = "C://OfficeCoder/";
	/**
	 * 控件xml属性库的绝对路径
	 */
	private String xmlLibraryPath = "D://javajar/Library/xml/Widget0.1.xml";
	/**
	 * 控件xml page库的绝对路径
	 */
	private String xmlPageLibraryPath = "D://javajar/Library/xml/Page0.1.xml";
	/**
	 * 用于页面编号
	 */
	private int pageNumber = 0;

	public XMLWorker(String UUID, String projectName) {
		fileName += UUID + "/" + projectName + "/xml/sourceXML.xml";
		createFile();
	}

	/**
	 * 创建xml文件
	 * 
	 * @return
	 */
	private void createFile() {

		try {
			// DocumentHelper提供了创建Document对象的方法
			Document document = DocumentHelper.createDocument();
			// 添加节点信息
			@SuppressWarnings("unused")
			Element rootElement = document.addElement("OfficeCoder");
			writeToXML(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加新的一页
	 * 
	 * @param pageName
	 * @param index
	 *            是否是首页
	 */
	public void addPage(boolean index, String type, String background,
			String backgroundtype,String url) {
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(fileName));
			/*
			 * 获取根结点
			 */
			Element root = xmlDoc.getRootElement();
			/*
			 * 创建Page结点
			 */
			Element pageNode = root.addElement("Page");
			pageNode.addAttribute("name", "page" + pageNumber);
			pageNode.addAttribute("index", Boolean.toString(index));
			pageNode.addAttribute("type", type);
			pageNode.addAttribute("background", background);
			pageNode.addAttribute("backgroundtype", backgroundtype);
			pageNode.addAttribute("url", url);

			pageNumber++;

			/*
			 * 将Document中的内容写会到xml中
			 */
			writeToXML(xmlDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 添加一整页
	 * 
	 * @param pageName
	 * @param index
	 *            是否是首页
	 */
	public void addFullPage(String pageName) {
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(fileName));
			/*
			 * xml库的Ducument对象
			 */
			Document xmlDocLibrary = sax.read(new File(xmlPageLibraryPath));
			/*
			 * 获取xml库的根结点
			 */
			Element rootLibraty = xmlDocLibrary.getRootElement();
			/*
			 * 要添加的页结点
			 */
			Element pageNode = null;
			/*
			 * 遍历xml库寻找需要复制的结点
			 */
			for (Iterator i = rootLibraty.elementIterator(); i.hasNext();) {
				Element temp = (Element) i.next();
				if (temp.attributeValue("name").equals(pageName)) {
					/*
					 * 将xml库中的结点的所有的元素都复制给widgetNode
					 */
					List list = temp.elements();
					temp = (Element) list.get(0);
					pageNode = (Element) temp.clone();
				}
			}

			/*
			 * 配置文件的Document对象
			 */
			Document xmlSourceDoc = sax.read(new File(fileName));
			/*
			 * 获取配置文件的根结点
			 */
			Element root = xmlSourceDoc.getRootElement();
			/*
			 * 添加新节点
			 */
			pageNode.setAttributeValue("name", "page" + pageNumber);
			root.add(pageNode);

			pageNumber++;

			/*
			 * 将Document中的内容写会到xml中
			 */
			writeToXML(xmlSourceDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 将Document中的内容写会到xml中
	 * 
	 * @param xmlDoc
	 */
	public void writeToXML(Document xmlDoc) {
		try {
			Writer fileWriter = new FileWriter(fileName);
			// dom4j提供了专门写入文件的对象XMLWriter
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(xmlDoc);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 在某一页中添加一个新的控件
	 * 
	 * @param pageName
	 *            page的名称
	 * @param widgetName
	 *            控件的名称
	 */
	@SuppressWarnings("rawtypes")
	public void addWidget(String pageName, String widgetName) {
		try {
			SAXReader sax = new SAXReader();

			/*
			 * xml库的Ducument对象
			 */
			Document xmlDocLibrary = sax.read(new File(xmlLibraryPath));
			/*
			 * 获取xml库的根结点
			 */
			Element rootLibraty = xmlDocLibrary.getRootElement();
			/*
			 * 要添加的库结点
			 */
			Element widgetNode = null;

			/*
			 * 遍历xml库寻找需要复制的结点
			 */
			for (Iterator i = rootLibraty.elementIterator(); i.hasNext();) {
				Element temp = (Element) i.next();
				if (temp.getName().equals(widgetName)) {
					/*
					 * 将xml库中的结点的所有的元素都复制给widgetNode
					 */
					widgetNode = (Element) temp.clone();
				}
			}

			/*
			 * 配置文件的Document对象
			 */
			Document xmlDoc = sax.read(new File(fileName));
			/*
			 * 获取配置文件的根结点
			 */
			Element root = xmlDoc.getRootElement();

			/*
			 * 遍历xml文档找到要添加的page结点
			 */
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element pageNode = (Element) i.next();
				if (pageNode.attributeValue("name").equals(pageName)) {
					/*
					 * 将复制下来的需要添加的结点添加到配置文件中
					 */
					pageNode.add(widgetNode);
					/*
					 * 将Document对象重新写入文件中，否则不起任何作用
					 */
					writeToXML(xmlDoc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
