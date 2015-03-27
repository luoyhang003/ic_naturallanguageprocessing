package com.officecoder.android;

public class Conf {

	/**appt.exe的路径，用于根据Manifest.xml文件生成R文件**/
	public static final String APPT_PATH = "D:\\install\\adt-bundle-windows-x86_64-20140321\\sdk\\build-tools\\android-4.4.2\\aapt.exe"; 
	
	/**aidl.exe的路径，用于将.aidl文件生成.java文件**/
	public static final String AIDL_PATH = "D:\\install\\adt-bundle-windows-x86_64-20140321\\sdk\\build-tools\\android-4.4.2\\aidl.exe";
	
	/**javac.exe的路径，用于将.java文件编译成.class文件**/
	public static final String JAVAC_PATH = "javac.exe";
	
	/**dx.bat命令行脚本的路径，用于生成classes.dex文件**/
	public static final String DX_PATH = "D:\\install\\adt-bundle-windows-x86_64-20140321\\sdk\\build-tools\\android-4.4.2\\dx.bat";

	/**将android源程序打包成不带证书和不含有签名的apk文件**/
	public static final String APKBUILDER_PATH = "D:\\install\\adt-bundle-windows-x86_64-20140321\\sdk\\tools\\apkbuilder.bat";
	
	/**keytool命令的地址，用于对生成的apk文件生成证书**/
	public static final String KEYTOOL_PATH = "keytool.exe";
	
	/**jarsigner命令的路径，用于对apk文件进行签名**/
	public static final String JARSIGNER_PATH = "jarsigner.exe";
	
	/**android.jar文件的路径**/
	public static final String ANDROID_JAR_PATH = "D:\\install\\adt-bundle-windows-x86_64-20140321\\sdk\\platforms\\android-19\\android.jar";

	/**java程序的路径**/
	public static final String JAVA_DEMO_PATH = "com.sdu.micro";
}
