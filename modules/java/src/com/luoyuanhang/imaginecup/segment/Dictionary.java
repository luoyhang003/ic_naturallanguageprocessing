package com.luoyuanhang.imaginecup.segment;

import java.util.ArrayList;

/**
 * 
 * @author Yuanhang Luo
 *
 */
public class Dictionary {
	//字典大小
	private int size = 0;
	//字典条目List
	private ArrayList<String[]> vocabularyList = new ArrayList<String[]>();
	
	
	private boolean isExist(String targetWord){
		int n = vocabularyList.size();
		for(int i = 0; i < n; i++){
			if(targetWord.equals(vocabularyList.get(i)[0]))
				return true;
		}
		return false;
	}
	
	/**
	 * 返回字典大小
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * 向词典中添加词
	 * @param word
	 * @param pos
	 */
	public void add(String word, String pos){
		String[] source = {word, pos};
		if(!isExist(source[0])){
			vocabularyList.add(source);
			size++;
		}
	}
	
	public String[] getWordAndPos(int index){
		return vocabularyList.get(index);
	}
	
	public String getWord(int index){
		return vocabularyList.get(index)[0];
	}
	
}















