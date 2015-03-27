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
 * ���ڽ��մӿͻ��˴�����Word�е����֣�Ȼ�������Ȼ���Է����㷨
 */
public class GetText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetText() {
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
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");

		/*
		 * ��ȡ�ͻ��˷�������Ϣ
		 */
		String content = readString(request);
		/*
		 * ��@@���зָ�
		 */
		String[] projectNameAndText = content.split("@@");
		/*
		 * �ֱ���ÿһ��
		 */
		String uuid = projectNameAndText[0];
		String projectName = projectNameAndText[1];
		String wordText = projectNameAndText[2];

		/*
		 * �ͻ��˵�UUIDĬ����OfficeCoder�������Ĭ�ϵ���Ҫ��������
		 */
		if (uuid.equals("OfficeCoder")) {
			uuid = createUUID();
		}
		/*
		 * ��UUID�����û����ļ��У��Լ����ι���
		 */
		createProject(uuid, projectName);
		/*
		 * �㷨����xml��Ҫ�����·��
		 */
		String xmlPath = "C:/OfficeCoder/" + uuid + "/" + projectName
				+ "/xml/sourceXML.xml";
		/*
		 * ������Ȼ���Է����㷨�㷨
		 */
		// alg(wordText,xmlPath);

		/*
		 * ��xml�ļ���UUIDͬʱ���ظ��ͻ���
		 */
		returnFile(request, response, "C:\\sourceXML2.xml", uuid);
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

	/**
	 * ��ͻ��˷����ļ�
	 * 
	 * @param request
	 * @return
	 */
	private void returnFile(HttpServletRequest request,
			HttpServletResponse response, String fileName, String uuid) {
		try {

			File file = new File(fileName);
			// ����ļ�����
			if (file.exists()) {
				/*
				 * ����Ӧͷ��������Ϣ
				 */
				response.setContentType(uuid);
				response.addHeader("Content-Disposition",
						"attachment; filename=\"" + fileName + "\"");
				// ��ȡ�ļ�
				InputStream inputStream = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				byte[] bytes = new byte[1024];
				ServletOutputStream outStream = response.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(outStream);
				int readLength = 0;
				while ((readLength = bis.read(bytes)) != -1) {
					bos.write(bytes, 0, readLength);
				}
				// �ͷ���Դ
				inputStream.close();
				bis.close();
				bos.flush();
				outStream.close();
				bos.close();
			} else {
				System.out.println("�ļ�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createProject(String UUID, String projectName) {
				
		/*
		 * δ�������û��ļ��е��ȴ����ļ���
		 */
		File UUIDFolder = new File("C:/OfficeCoder/" + UUID);
		/*
		 * �����µĹ���
		 */
		UUIDFolder.mkdir();
		
		OCDirector director = OCDirector.getInstance();
		/*
		 * ���ù������Լ������ļ�������
		 */
		director.setAppname(projectName);

		/*
		 * ���ù��̸�Ŀ¼��ַ
		 */
		director.setProjectPath("C:/OfficeCoder/" + UUID + "/");

		/*
		 * �½�����
		 */
		OCCreater.creatNewProject();
	}

	/**
	 * ����jar����ÿ���û�Ψһ�ı�ʶ��
	 * 
	 * @return
	 */
	private String createUUID() {
		/*
		 * ����java����ķ���
		 */
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
}
