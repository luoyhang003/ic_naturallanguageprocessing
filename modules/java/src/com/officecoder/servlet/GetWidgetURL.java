package com.officecoder.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import OCPage.OCPage;
import OCValue.OCWidgetURL;

/**
 * ���ͻ�������µĿؼ�ʱ�����ô�servlet��ÿؼ���URL
 */
public class GetWidgetURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetWidgetURL() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("������GET����");
	}

	/**
	 * post�����ӿͻ��˴�����Ϣ
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("������POST����");
		/*
		 * ��ÿͻ��˷����Ŀؼ�������
		 */
		String content = readString(request);
		String node = getWidgetNode(content);

		try {
			PrintWriter out = response.getWriter();
			out.println(node);
			System.out.println(node);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ�ӿͻ��˴�������Ϣ
	 * 
	 * @param request
	 * @return
	 */
	private String readString(HttpServletRequest request) {
		StringBuffer str = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}

	private String getWidgetNode(String widget) {
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
