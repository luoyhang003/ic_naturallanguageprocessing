package com.officecoder.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于接收从客户端传来的xml、mp3、图片文件
 */
public class GetFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetFile() {
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

		PrintWriter out = response.getWriter();
		out.println("已接收");
		out.flush();
		out.close();

	}

	/**
	 * 根据不同的类型将客户端上传的文件放到不同的文件夹里
	 * 
	 * @param request
	 */
	public void getFileTypeAndName(HttpServletRequest request) {

		String fileInfo = request.getContentType();
		String[] typeAndName = fileInfo.split("@@");

		String UUID = typeAndName[0];
		String projectName = typeAndName[1];
		String fileType = typeAndName[2];
		String fileName = typeAndName[3];

		String rootPath = "C://OfficeCoder/" + UUID + "/" + projectName + "/";
		String filePath = "";
		/*
		 * 根据文件的类型将文件放入到每个用户不用的文件夹中
		 */
		if (fileType.equals("image")) {
			filePath += rootPath + "img/" + fileName;
		} else if (fileType.equals("music")) {
			filePath += rootPath + "music/" + fileName;
		} else {
			System.out.println("客户端上传的文件错误");
		}

		readFile(request, filePath);
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
			FileOutputStream file_out = new FileOutputStream(file);
			int b;
			while ((b = fin.read()) != -1) {
				file_out.write(b);
			}
			fin.close();
			file_out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
