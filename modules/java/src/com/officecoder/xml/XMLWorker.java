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
 * xmlԴ�ļ��Ĵ����Ͳ���
 * 
 * @author xing
 * 
 */
public class XMLWorker {

	/**
	 * Դ�ļ��ľ���·������
	 */
	private String fileName = "C://OfficeCoder/";
	/**
	 * �ؼ�xml���Կ�ľ���·��
	 */
	private String xmlLibraryPath = "D://javajar/Library/xml/Widget0.1.xml";
	/**
	 * �ؼ�xml page��ľ���·��
	 */
	private String xmlPageLibraryPath = "D://javajar/Library/xml/Page0.1.xml";
	/**
	 * ����ҳ����
	 */
	private int pageNumber = 0;

	public XMLWorker(String UUID, String projectName) {
		fileName += UUID + "/" + projectName + "/xml/sourceXML.xml";
		createFile();
	}

	/**
	 * ����xml�ļ�
	 * 
	 * @return
	 */
	private void createFile() {

		try {
			// DocumentHelper�ṩ�˴���Document����ķ���
			Document document = DocumentHelper.createDocument();
			// ��ӽڵ���Ϣ
			@SuppressWarnings("unused")
			Element rootElement = document.addElement("OfficeCoder");
			writeToXML(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����µ�һҳ
	 * 
	 * @param pageName
	 * @param index
	 *            �Ƿ�����ҳ
	 */
	public void addPage(boolean index, String type, String background,
			String backgroundtype,String url) {
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(fileName));
			/*
			 * ��ȡ�����
			 */
			Element root = xmlDoc.getRootElement();
			/*
			 * ����Page���
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
			 * ��Document�е�����д�ᵽxml��
			 */
			writeToXML(xmlDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ���һ��ҳ
	 * 
	 * @param pageName
	 * @param index
	 *            �Ƿ�����ҳ
	 */
	public void addFullPage(String pageName) {
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(fileName));
			/*
			 * xml���Ducument����
			 */
			Document xmlDocLibrary = sax.read(new File(xmlPageLibraryPath));
			/*
			 * ��ȡxml��ĸ����
			 */
			Element rootLibraty = xmlDocLibrary.getRootElement();
			/*
			 * Ҫ��ӵ�ҳ���
			 */
			Element pageNode = null;
			/*
			 * ����xml��Ѱ����Ҫ���ƵĽ��
			 */
			for (Iterator i = rootLibraty.elementIterator(); i.hasNext();) {
				Element temp = (Element) i.next();
				if (temp.attributeValue("name").equals(pageName)) {
					/*
					 * ��xml���еĽ������е�Ԫ�ض����Ƹ�widgetNode
					 */
					List list = temp.elements();
					temp = (Element) list.get(0);
					pageNode = (Element) temp.clone();
				}
			}

			/*
			 * �����ļ���Document����
			 */
			Document xmlSourceDoc = sax.read(new File(fileName));
			/*
			 * ��ȡ�����ļ��ĸ����
			 */
			Element root = xmlSourceDoc.getRootElement();
			/*
			 * ����½ڵ�
			 */
			pageNode.setAttributeValue("name", "page" + pageNumber);
			root.add(pageNode);

			pageNumber++;

			/*
			 * ��Document�е�����д�ᵽxml��
			 */
			writeToXML(xmlSourceDoc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��Document�е�����д�ᵽxml��
	 * 
	 * @param xmlDoc
	 */
	public void writeToXML(Document xmlDoc) {
		try {
			Writer fileWriter = new FileWriter(fileName);
			// dom4j�ṩ��ר��д���ļ��Ķ���XMLWriter
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(xmlDoc);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ĳһҳ�����һ���µĿؼ�
	 * 
	 * @param pageName
	 *            page������
	 * @param widgetName
	 *            �ؼ�������
	 */
	@SuppressWarnings("rawtypes")
	public void addWidget(String pageName, String widgetName) {
		try {
			SAXReader sax = new SAXReader();

			/*
			 * xml���Ducument����
			 */
			Document xmlDocLibrary = sax.read(new File(xmlLibraryPath));
			/*
			 * ��ȡxml��ĸ����
			 */
			Element rootLibraty = xmlDocLibrary.getRootElement();
			/*
			 * Ҫ��ӵĿ���
			 */
			Element widgetNode = null;

			/*
			 * ����xml��Ѱ����Ҫ���ƵĽ��
			 */
			for (Iterator i = rootLibraty.elementIterator(); i.hasNext();) {
				Element temp = (Element) i.next();
				if (temp.getName().equals(widgetName)) {
					/*
					 * ��xml���еĽ������е�Ԫ�ض����Ƹ�widgetNode
					 */
					widgetNode = (Element) temp.clone();
				}
			}

			/*
			 * �����ļ���Document����
			 */
			Document xmlDoc = sax.read(new File(fileName));
			/*
			 * ��ȡ�����ļ��ĸ����
			 */
			Element root = xmlDoc.getRootElement();

			/*
			 * ����xml�ĵ��ҵ�Ҫ��ӵ�page���
			 */
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element pageNode = (Element) i.next();
				if (pageNode.attributeValue("name").equals(pageName)) {
					/*
					 * ��������������Ҫ��ӵĽ����ӵ������ļ���
					 */
					pageNode.add(widgetNode);
					/*
					 * ��Document��������д���ļ��У��������κ�����
					 */
					writeToXML(xmlDoc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
