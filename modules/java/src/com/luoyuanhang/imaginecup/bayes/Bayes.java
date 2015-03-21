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
	public static Dictionary dictionary = new Dictionary();
	
	public static void init(){
		buildDictionary();
	}
	
	public static void buildDictionary(){
		String filePath = "traindata";
		ArrayList<String> strList = new ArrayList<String>();

		try{
			File root = new File(filePath);
			File files[] = root.listFiles();
			for(File file:files){
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferReader = new BufferedReader(read);
				String lineText = "";
				while((lineText = bufferReader.readLine()) != null){
					String str = NLPIR.SegmentWithPos(lineText);
					
					String words[] = str.split(" ");
					
					for(int i = 0; i < words.length; i++){
						for(int j = 0; j < SYMBOL.POS_USELESS.length; j++){
							if(words[i].contains(SYMBOL.POS_USELESS[j]))
								words[i]="";
						}
						for(int j = 0; j < SYMBOL.PUNC_CODE.length;j++){
							if(words[i].contains(SYMBOL.PUNC_CODE[j]))
								words[i]="";
						}
						if(words[i]!=""){
							strList.add(words[i]);
						}
					}
					
				}
				bufferReader.close();
				read.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		for(int i = 0; i < strList.size(); i++){
			String str = strList.get(i);
			String temp[] = str.split("/");
			System.out.println(temp[0]+" -- "+temp[1]);
			dictionary.add(temp[0], temp[1]);
		}

	}
}
