package com.officecoder.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OCTools.OCDownload;

import com.officecoder.android.CompilerUtil;
import com.officecoder.xml.XMLReader;

/**
 * �����û��޸���ɵ�xml�ļ���Ȼ��apk�������ӷ������ͻ���
 */
public class GetXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * �������ӵĸ�Ŀ¼
	 */
	private String downloadRootURL = "http://211.87.226.156:8080/OfficeCoder/";

	public GetXML() {
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
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("������POST����");
		getFileTypeAndName(request);

		/*
		 * ���ص���ʾ���棬��ʱ���ܸ���
		 */
		String downloadURL = "211.87.226.145:8080/OfficeCoder/Download/index.html";
		/*
		 * ����URL
		 */
		PrintWriter out = response.getWriter();
		out.println(downloadURL);
		out.flush();
		out.close();

	}

	/**
	 * ����xml�ļ����ڹ̶����ļ�����
	 * 
	 * @param request
	 */
	public String getFileTypeAndName(HttpServletRequest request) {

		String fileInfo = request.getContentType();
		String[] typeAndName = fileInfo.split("@@");

		String UUID = typeAndName[0];
		String projectName = typeAndName[1];
		String fileName = typeAndName[2];

		String rootPath = "C:/OfficeCoder/" + UUID + "/" + projectName + "/";
		String filePath = "";

		filePath += rootPath + "xml/" + fileName;

		System.out.println(filePath);

		/*
		 * ��ȡ���������ļ�
		 */
		readFile(request, filePath);

		/*
		 * ����xml�ļ�����װ��Project
		 */
		XMLReader xmlReader = new XMLReader();
		xmlReader.XMLToHTML(filePath);

		/*
		 * ���빤��
		 */
		CompilerUtil cu = new CompilerUtil("E:\\android\\OfficeCoder_Android",
				projectName);
		CompileToAndroid(cu, "C://OfficeCoder/" + UUID + "/" + projectName
				+ "/a1.html", UUID, projectName);

		/*
		 * ��װ��������
		 */

		String downloadURL = downloadRootURL + UUID + "/" + projectName + "/"
				+ "apk/" + projectName + ".apk";

		OCDownload down = new OCDownload(downloadURL);
		down.setAttr();

		return downloadURL;
	}

	/**
	 * ��ȡ�ӿͻ��˴������ļ�
	 * 
	 * @param request
	 * @return
	 */
	private void readFile(HttpServletRequest request, String file_path_name) {
		try {
			InputStream fin = request.getInputStream();
			File file = new File(file_path_name);

			OutputStreamWriter write = new OutputStreamWriter(
					new FileOutputStream(file), "GBK");
			BufferedWriter bufw = new BufferedWriter(write);

			// FileOutputStream file_out = new FileOutputStream(file);
			int b;
			while ((b = fin.read()) != -1) {
				bufw.write(b);
			}

			fin.close();
			bufw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param cu
	 * @param url
	 *            app�׵�ַ
	 * @param name
	 *            app������
	 */
	private void CompileToAndroid(CompilerUtil cu, String url, String UUID,
			String projectName) {
		/*
		 * �Է���������ʹͬһʱ��ֻ����һ������ִ�б������
		 */
		synchronized (CompilerUtil.class) {
			cu.setURL(url);
			cu.generateR();
			cu.compileJava();
			cu.generateClasses();
			cu.compileRes();
			cu.apkbuilder();
			cu.generateKeytool();
			cu.signJar();
			cu.copyApk(UUID, projectName);
			cu.deleteApk(projectName);
			cu.deleteKeyFile();
		}
	}
}
