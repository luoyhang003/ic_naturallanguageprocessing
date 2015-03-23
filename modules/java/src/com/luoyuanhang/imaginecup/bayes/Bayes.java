package com.luoyuanhang.imaginecup.bayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.luoyuanhang.imaginecup.segment.Dictionary;
import com.luoyuanhang.imaginecup.segment.NLPIR;
import com.luoyuanhang.imaginecup.segment.SYMBOL;


/**
 * 贝叶斯分类器
 * @author Yuahang Luo
 *
 */
public class Bayes {
	//词语List
	public static ArrayList<String> VOCABULARIES_LIST;
	//词典对象
	public static Dictionary dictionary = new Dictionary();
	
	/**
	 * 初始化方法
	 */
	public static void init(){
		buildDictionary();
	}
	
	/**
	 * 建立词典
	 */
	public static void buildDictionary(){
		//训练数据目录
		String filePath = "traindata";
		//词语List
		ArrayList<String> strList = new ArrayList<String>();

		try{
			//处理该目录下所有训练文本
			File root = new File(filePath);
			File files[] = root.listFiles();
			for(File file:files){
				//读取所有训练文本
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferReader = new BufferedReader(read);
				String lineText = "";
				while((lineText = bufferReader.readLine()) != null){
					//对每句话进行分词
					String str = NLPIR.SegmentWithPos(lineText);
					//分词后结果，带有无意义词和标点
					String words[] = str.split(" ");
					
					for(int i = 0; i < words.length; i++){
						//去除无意义词
						for(int j = 0; j < SYMBOL.POS_USELESS.length; j++){
							if(words[i].contains(SYMBOL.POS_USELESS[j]))
								words[i]="";
						}
						//去除标点
						for(int j = 0; j < SYMBOL.PUNC_CODE.length;j++){
							if(words[i].contains(SYMBOL.PUNC_CODE[j]))
								words[i]="";
						}
						//将分词结果添加至List
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
		
		//将分好的词语和词性标注存入Dictionary
		for(int i = 0; i < strList.size(); i++){
			String str = strList.get(i);
			String temp[] = str.split("/");
			dictionary.add(temp[0], temp[1]);
		}

	}
}
