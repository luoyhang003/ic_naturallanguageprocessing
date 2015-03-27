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
 * 当客户端添加新的控件时，调用次servlet获得控件的URL
 */
public class GetWidgetURL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetWidgetURL() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("调用了GET方法");
	}

	/**
	 * post方法从客户端传递信息
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("调用了POST方法");
		/*
		 * 获得客户端发来的控件的名称
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
	 * 获取从客户端传来的信息
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
