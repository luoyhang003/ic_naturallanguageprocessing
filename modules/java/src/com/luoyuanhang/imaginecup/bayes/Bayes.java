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
 * ��Ҷ˹������
 * @author Yuahang Luo
 *
 */
public class Bayes {
	//����List
	public static ArrayList<String> VOCABULARIES_LIST;
	//�ʵ����
	public static Dictionary dictionary = new Dictionary();
	
	/**
	 * ��ʼ������
	 */
	public static void init(){
		buildDictionary();
	}
	
	/**
	 * �����ʵ�
	 */
	public static void buildDictionary(){
		//ѵ������Ŀ¼
		String filePath = "traindata";
		//����List
		ArrayList<String> strList = new ArrayList<String>();

		try{
			//�����Ŀ¼������ѵ���ı�
			File root = new File(filePath);
			File files[] = root.listFiles();
			for(File file:files){
				//��ȡ����ѵ���ı�
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferReader = new BufferedReader(read);
				String lineText = "";
				while((lineText = bufferReader.readLine()) != null){
					//��ÿ�仰���зִ�
					String str = NLPIR.SegmentWithPos(lineText);
					//�ִʺ���������������ʺͱ��
					String words[] = str.split(" ");
					
					for(int i = 0; i < words.length; i++){
						//ȥ���������
						for(int j = 0; j < SYMBOL.POS_USELESS.length; j++){
							if(words[i].contains(SYMBOL.POS_USELESS[j]))
								words[i]="";
						}
						//ȥ�����
						for(int j = 0; j < SYMBOL.PUNC_CODE.length;j++){
							if(words[i].contains(SYMBOL.PUNC_CODE[j]))
								words[i]="";
						}
						//���ִʽ�������List
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
		
		//���ֺõĴ���ʹ��Ա�ע����Dictionary
		for(int i = 0; i < strList.size(); i++){
			String str = strList.get(i);
			String temp[] = str.split("/");
			dictionary.add(temp[0], temp[1]);
		}

	}
}
