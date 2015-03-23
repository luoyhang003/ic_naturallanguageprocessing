package com.luoyuanhang.imaginecup.segment;
/**
 * 各种符号库
 * 包括：
 * 	1.标点库
 * 	2.词性标注库
 * 
 * @author Luo Yuanhang
 *
 */
public class SYMBOL {
	/*-------------分句标点--------------*/
	public static String PUNC_SENTENCE = ".?!。？！：:";
	/*-----------分句标点词性标注-----------*/
	public static String[] PUNC_CODE = {"/wkz","/wky","/wyx","/wyy","/wj","/ww","/wt","/wd","/wf","/wn","/wm","/ws","/wp","/wb","/wh"};
	/*-----------无意义词性标注------------*/
	public static String[] POS_USELESS = {"/u","/d","/q","/vshi","/vyou","/z","/a","/m","/p","/e","/x","/y","/cc"};
	/*----------用户自定义词典标注----------*/
	public static String[] POS_UESRDIC = {"/PAGE ","/WID "};
	/*-------------实义词---------------*/
	public static String[] POS_USE = {"/PAGE","/WID","/n"};
	
	/**
	 * 判断标注是否出现在标注组中
	 * @param arr
	 * @param source
	 * @return
	 */
	public static boolean isExist(String[] arr, String source){
		for(int i = 0; i < arr.length; i++){
			if(source.contains(arr[i]))
				return true;
		}
		return false;
	}
}
