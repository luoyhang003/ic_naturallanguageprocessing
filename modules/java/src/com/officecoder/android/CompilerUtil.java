package com.officecoder.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import OCDirector.OCDirector;
import OCPage.OCPage;
import OCTools.OCFileWorker;
import OCValue.OCStaticValue;

public class CompilerUtil {

	/**
	 * ���ɵ�apk������
	 */
	private String app_name;
	/** �û������android�����Դ�����Ŀ¼ **/
	private String demo_path = null;

	public CompilerUtil(String args, String app_name) {
		this.demo_path = args;
		this.app_name = app_name;
	}

	public CompilerUtil() {

	}

	public String getDemo_path() {
		return demo_path;
	}

	public void setDemo_path(String demo_path) {
		this.demo_path = demo_path;
	}

	/**
	 * ��genĿ¼������R�ļ�
	 */
	public void generateR() {
		try {
			String command = Conf.APPT_PATH + " p -f -m -J " + demo_path
					+ "/gen -S " + demo_path + "/res -I "
					+ Conf.ANDROID_JAR_PATH + "-M " + demo_path
					+ "/AndroidManifest.xml";
			;

			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ú�����ʱ����Ҫ���壬�����ǵĹ�������ʱʹ�ò���
	 */
	public void compileAIDL() {

	}

	/**
	 * ��java��������.class�ļ�
	 */
	public void compileJava() {
		try {
			String command = Conf.JAVAC_PATH
					+ " -encoding GBK -target 1.7 -bootclasspath "
					+ Conf.ANDROID_JAR_PATH + " -d " + demo_path + "/bin "
					+ demo_path + "/src/" + Conf.JAVA_DEMO_PATH + "/*.java "
					+ demo_path + "/gen/" + Conf.JAVA_DEMO_PATH + "/R.java";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����classes.dex�ļ�
	 */
	public void generateClasses() {
		try {
			String command = Conf.DX_PATH + " --dex --output=" + demo_path
					+ "/bin/classes.dex " + demo_path + "/bin/classes";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������Դ���ļ�
	 */
	public void compileRes() {
		try {
			String command = Conf.APPT_PATH + " package -f -S " + demo_path
					+ "/res " + "-I " + Conf.ANDROID_JAR_PATH + " -A "
					+ demo_path + "/assets -M " + demo_path
					+ "/AndroidManifest.xml -F " + demo_path + "/bin/hello";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����δǩ����apk
	 */
	public void apkbuilder() {
		// f:\explorer\byreadreader.apk �Cv -u -z
		// f:\explorer\AndroidByread\bin\byreadreader -f
		// f:\explorer\AndroidByread\bin\class.dex -rf
		// F:\explorer\AndroidByread\src
		try {
			String command = Conf.APKBUILDER_PATH + " " + demo_path + "/bin/"
					+ app_name + "_unsigned.apk -v -u -z " + demo_path
					+ "/bin/hello -f " + demo_path + "/bin/classes.dex -rf "
					+ demo_path + "/src";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ʹ��keytool��������֤���ļ�
	 */
	public void generateKeytool() {
		try {
			String command = Conf.KEYTOOL_PATH
					+ " -genkey -alias "
					+ demo_path
					+ "/hello.keystore -keyalg RSA -validity 4000 -keystore "
					+ demo_path
					+ "/hello.keystore -dname \"CN=w,OU=w,O=localhost,L=w,ST=w,C=CN\" -keypass 123456 -storepass 123456";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void signJar() {
		try {
			String command = Conf.JARSIGNER_PATH
					+ " -keystore "
					+ demo_path
					+ "/hello.keystore -storepass 123456 -keypass 123456 -signedjar "
					+ demo_path + "/bin/" + app_name + ".apk " + demo_path
					+ "/bin/" + app_name + "_unsigned.apk " + demo_path
					+ "/hello.keystore";
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p.getInputStream(), "GBK"));// ע�����ı�������

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("StartedLog==>" + line);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void compile() {
		generateR();
		compileAIDL();
		compileJava();
		generateClasses();
		compileRes();
		apkbuilder();
		generateKeytool();
		signJar();
	}

	/**
	 * ��URLд��txt�ļ���
	 * 
	 * @param url
	 */
	public void setURL(String url) {
		try {
			File writename = new File(
					"E:\\android\\OfficeCoder_Android\\src\\Properties\\url.txt");
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(url);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ��key�ļ�
	 */
	public void deleteKeyFile() {
		File file = new File("E://android/OfficeCoder_Android/hello.keystore");
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}

	/**
	 * ����װ�����Ƶ��û��Լ����ļ�����
	 * 
	 * @param UUID
	 * @param projectName
	 */
	public void copyApk(String UUID, String projectName) {
		File srcApk = new File(demo_path+"\\bin\\" + projectName + ".apk");
		File destApk = new File("C://OfficeCoder/" + UUID + "/" + projectName
				+ "/apk");
		OCFileWorker.copyFile(srcApk, destApk, projectName + ".apk");
	}
	
	/**
	 * ɾ���������ɵ�APK
	 */
	public void deleteApk(String projectName){
		File file1 = new File(demo_path+"\\bin\\"+projectName+".apk");
		if (file1.isFile() && file1.exists()) {
			file1.delete();
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
		
		File file2 = new File(demo_path+"\\bin\\"+projectName+"_unsigned.apk");
		if (file2.isFile() && file2.exists()) {
			file2.delete();
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}
}
