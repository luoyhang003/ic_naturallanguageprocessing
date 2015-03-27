package com.officecoder.android;

public class CompileAndroid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompilerUtil cu = new CompilerUtil("D:\\android\\OfficeCoder_Android","hello");
		cu.generateKeytool();
		cu.generateR();
		cu.compileJava();
		cu.generateClasses();
		cu.compileRes();
		cu.apkbuilder();		
		cu.signJar();
		cu.deleteKeyFile();
	}

}
