package com.luoyuanhang.imaginecup.segment;

import java.util.ArrayList;

/**
 * 
 * @author Yuanhang Luo
 *
 */
public class Dictionary {
	//�ֵ��С
	private int size = 0;
	//�ֵ���ĿList
	private ArrayList<String[]> vocabularyList = new ArrayList<String[]>();
	

	/**
	 * �ж�ĳ���Ƿ�����ڴʵ���
	 * @param targetWord
	 * @return
	 */
	private boolean isExist(String targetWord){
		int n = vocabularyList.size();
		for(int i = 0; i < n; i++){
			if(targetWord.equals(vocabularyList.get(i)[0]))
				return true; 
		}
		return false;
	}
	
	/**
	 * �����ֵ��С
	 * @return
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * ��ʵ�����Ӵ�
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
	
	/**
	 * �õ�����ʹ��Ա�ע
	 * @param index
	 * @return
	 */
	public String[] getWordAndPos(int index){
		return vocabularyList.get(index);
	}
	
	/**
	 * ����ȡ����
	 * @param index
	 * @return
	 */
	public String getWord(int index){
		return vocabularyList.get(index)[0];
	}
	
	public void outputAllWords(){
		for(int i = 0; i < size; i++){
			System.out.println(vocabularyList.get(i)[0]);
		}
	}
	
}















