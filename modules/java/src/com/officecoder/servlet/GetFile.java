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
 * ���ڽ��մӿͻ��˴�����xml��mp3��ͼƬ�ļ�
 */
public class GetFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetFile() {
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

		PrintWriter out = response.getWriter();
		out.println("�ѽ���");
		out.flush();
		out.close();

	}

	/**
	 * ���ݲ�ͬ�����ͽ��ͻ����ϴ����ļ��ŵ���ͬ���ļ�����
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
		 * �����ļ������ͽ��ļ����뵽ÿ���û����õ��ļ�����
		 */
		if (fileType.equals("image")) {
			filePath += rootPath + "img/" + fileName;
		} else if (fileType.equals("music")) {
			filePath += rootPath + "music/" + fileName;
		} else {
			System.out.println("�ͻ����ϴ����ļ�����");
		}

		readFile(request, filePath);
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
