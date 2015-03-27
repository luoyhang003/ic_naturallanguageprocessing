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
 * 接收用户修改完成的xml文件，然后将apk下载链接发动给客户端
 */
public class GetXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * 下载链接的根目录
	 */
	private String downloadRootURL = "http://211.87.226.156:8080/OfficeCoder/";

	public GetXML() {
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
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("调用了POST方法");
		getFileTypeAndName(request);

		/*
		 * 下载的提示界面，随时可能更改
		 */
		String downloadURL = "211.87.226.145:8080/OfficeCoder/Download/index.html";
		/*
		 * 返回URL
		 */
		PrintWriter out = response.getWriter();
		out.println(downloadURL);
		out.flush();
		out.close();

	}

	/**
	 * 根据xml文件放在固定的文件夹里
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
		 * 读取发过来的文件
		 */
		readFile(request, filePath);

		/*
		 * 解析xml文件，组装成Project
		 */
		XMLReader xmlReader = new XMLReader();
		xmlReader.XMLToHTML(filePath);

		/*
		 * 编译工程
		 */
		CompilerUtil cu = new CompilerUtil("E:\\android\\OfficeCoder_Android",
				projectName);
		CompileToAndroid(cu, "C://OfficeCoder/" + UUID + "/" + projectName
				+ "/a1.html", UUID, projectName);

		/*
		 * 组装下载链接
		 */

		String downloadURL = downloadRootURL + UUID + "/" + projectName + "/"
				+ "apk/" + projectName + ".apk";

		OCDownload down = new OCDownload(downloadURL);
		down.setAttr();

		return downloadURL;
	}

	/**
	 * 获取从客户端传来的文件
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
	 *            app首地址
	 * @param name
	 *            app的名称
	 */
	private void CompileToAndroid(CompilerUtil cu, String url, String UUID,
			String projectName) {
		/*
		 * 对方法加锁，使同一时刻只能有一个工程执行编译操作
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
