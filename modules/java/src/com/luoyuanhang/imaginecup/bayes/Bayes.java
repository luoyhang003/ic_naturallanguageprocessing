package com.luoyuanhang.imaginecup.bayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.luoyuanhang.imaginecup.segment.Dictionary;
import com.luoyuanhang.imaginecup.segment.NLPIR;
import com.luoyuanhang.imaginecup.segment.SYMBOL;



public class Bayes {
	public static ArrayList<String> VOCABULARIES_LIST;
	public static Dictionary dictionary;
	
	public static void init(){
		buildDictionary();
		for(int i = 0; i < VOCABULARIES_LIST.size(); i++){
			System.out.println(VOCABULARIES_LIST.get(i));
		}
	}
	
	public static void buildDictionary(){
		String filePath = "traindata";
		try{
			File root = new File(filePath);
			File files[] = root.listFiles();
			for(File file:files){
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferReader = new BufferedReader(read);
				String lineText = "";
				while((lineText = bufferReader.readLine()) != null){
					String str[] = NLPIR.SegmentNoPos(lineText);
					ArrayList<String> strList = new ArrayList<String>();
					for(int i = 0; i < str.length; i++){
						for(int j = 0; j < SYMBOL.POS_USELESS.length; j++){
							
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
