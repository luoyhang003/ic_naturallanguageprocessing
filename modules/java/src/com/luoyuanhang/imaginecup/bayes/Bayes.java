package com.luoyuanhang.imaginecup.bayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Bayes {
	static ArrayList<String> VOCABULARIES_LIST;
	
	static void init(){
		//TODO
	}
	
	static void buildDictionary(){
		String filePath = "traindata";
		try{
			File root = new File(filePath);
			File files[] = root.listFiles();
			for(File file:files){
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferReader = new BufferedReader(read);
				String lineText = "";
				while((lineText = bufferReader.readLine()) != null){
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
