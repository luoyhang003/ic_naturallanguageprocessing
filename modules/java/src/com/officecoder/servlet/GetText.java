package com.officecoder.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import OCDirector.OCDirector;
import OCTools.OCCreater;

/**
 * 用于接收从客户端传来的Word中的文字，然后调用自然语言分析算法
 */
public class GetText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetText() {
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
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");

		/*
		 * 读取客户端发来的信息
		 */
		String content = readString(request);
		/*
		 * 用@@进行分割
		 */
		String[] projectNameAndText = content.split("@@");
		/*
		 * 分别获得每一项
		 */
		String uuid = projectNameAndText[0];
		String projectName = projectNameAndText[1];
		String wordText = projectNameAndText[2];

		/*
		 * 客户端的UUID默认是OfficeCoder，如果是默认的需要重新生成
		 */
		if (uuid.equals("OfficeCoder")) {
			uuid = createUUID();
		}
		/*
		 * 用UUID建立用户的文件夹，以及本次工程
		 */
		createProject(uuid, projectName);
		/*
		 * 算法生成xml是要保存的路径
		 */
		String xmlPath = "C:/OfficeCoder/" + uuid + "/" + projectName
				+ "/xml/sourceXML.xml";
		/*
		 * 调用自然语言分析算法算法
		 */
		// alg(wordText,xmlPath);

		/*
		 * 将xml文件和UUID同时返回给客户端
		 */
		returnFile(request, response, "C:\\sourceXML2.xml", uuid);
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

	/**
	 * 像客户端发送文件
	 * 
	 * @param request
	 * @return
	 */
	private void returnFile(HttpServletRequest request,
			HttpServletResponse response, String fileName, String uuid) {
		try {

			File file = new File(fileName);
			// 如果文件存在
			if (file.exists()) {
				/*
				 * 用响应头来传递信息
				 */
				response.setContentType(uuid);
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + fileName + "\"");
				// 读取文件
				InputStream inputStream = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				byte[] bytes = new byte[1024];
				ServletOutputStream outStream = response.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(outStream);
				int readLength = 0;
				while ((readLength = bis.read(bytes)) != -1) {
					bos.write(bytes, 0, readLength);
				}
				// 释放资源
				inputStream.close();
				bis.close();
				bos.flush();
				outStream.close();
				bos.close();
			} else {
				System.out.println("文件不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createProject(String UUID, String projectName) {
				
		/*
		 * 未建立过用户文件夹的先创建文件夹
		 */
		File UUIDFolder = new File("C:/OfficeCoder/" + UUID);
		/*
		 * 创建新的工程
		 */
		UUIDFolder.mkdir();
		
		OCDirector director = OCDirector.getInstance();
		/*
		 * 设置工程名以及工程文件夹名称
		 */
		director.setAppname(projectName);

		/*
		 * 设置工程根目录地址
		 */
		director.setProjectPath("C:/OfficeCoder/" + UUID + "/");

		/*
		 * 新建工程
		 */
		OCCreater.creatNewProject();
	}

	/**
	 * 调用jar生成每个用户唯一的标识号
	 * 
	 * @return
	 */
	private String createUUID() {
		/*
		 * 调用java自身的方法
		 */
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
}
