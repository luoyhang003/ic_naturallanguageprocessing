package com.luoyuanhang.imaginecup.segment;
/**
 * ���ַ��ſ�
 * ������
 * 	1.����
 * 	2.���Ա�ע��
 * 
 * @author Luo Yuanhang
 *
 */
public class SYMBOL {
	/*-------------�־���--------------*/
	public static String PUNC_SENTENCE = ".?!��������:";
	/*-----------�־�����Ա�ע-----------*/
	public static String[] PUNC_CODE = {"/wkz","/wky","/wyx","/wyy","/wj","/ww","/wt","/wd","/wf","/wn","/wm","/ws","/wp","/wb","/wh"};
	/*-----------��������Ա�ע------------*/
	public static String[] POS_USELESS = {"/u","/d","/q","/vshi","/vyou","/z","/a","/m","/p","/e","/x","/y","/cc"};
	/*----------�û��Զ���ʵ��ע----------*/
	public static String[] POS_UESRDIC = {"/PAGE ","/WID "};
	/*-------------ʵ���---------------*/
	public static String[] POS_USE = {"/PAGE","/WID","/n"};
	
	/**
	 * �жϱ�ע�Ƿ�����ڱ�ע����
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
