package com.luoyuanhang.imaginecup.segment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


//import utils.SystemParas;
import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * ���ڷִʵ���
 * @author Administrator
 *
 */
public class NLPIR {

	//����JNA�ӿ�
	public interface CLibrary extends Library{
		//����ʵ��
		CLibrary Instance = (CLibrary)Native.loadLibrary("./libs/NLPIR", CLibrary.class);
		//ϵͳ��ʼ��
		public int NLPIR_Init(byte[] sDataPath, int encoding,byte[] sLicenceCode);
		//���䴦��
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
		//��ȡ�ؼ���
		public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit,boolean bWeightOut);
		//�˳�����
		public void NLPIR_Exit();
		//�ĵ�����
		public double NLPIR_FileProcess(String sSourceFilename,String sResultFilename,int bPOStagged);
		//�����û��Զ���ʵ�
		public int NLPIR_ImportUserDict(String sFilename,Boolean bOverwrite);
		//����û��´ʲ���ע����
		public int NLPIR_AddUserWord(String sWords);
	}
	
	/**
	 * ��һ�����ֽ��зִʣ����ر�ע���Եķִʽ��
	 * 
	 * @param fileName
	 * @return words
	 * @throws Exception
	 */
	public static String[] Segment(String fileName) throws Exception{
		//����ִʽ��
		String result[]={"",""};
		String sourceString = "";
		//���ļ��ж����ı�
		try {
            String encoding="UTF-8";
            
            File file=new File(fileName);
            
            if(file.isFile() && file.exists()){
            	//�ж��ļ��Ƿ����
            	String temp = null;
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);

                while((temp = bufferedReader.readLine()) != null){
                    sourceString += temp;
                }

                read.close();
            }else{
            	System.out.println("�Ҳ���ָ�����ļ�");
            }
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		//���зִʣ���NLPIR��ʼ��
		String argu = "";
		String system_charset = "UTF-8";
		int charset_type = 1;
		int init_flag = CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset), charset_type, "1".getBytes(system_charset));
				
		AddUserWords("dic/dic.txt");
		
		if(0 == init_flag){
			System.out.println("init fail!");
			return null;
		}
		//����ִʽ��		
		String nativeBytes = null;
		//����ؼ���
		String nativeByte = null;
		try{
			//�ִ�
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sourceString, 1);
			//��ȡ�ؼ���
			nativeByte = CLibrary.Instance.NLPIR_GetKeyWords(sourceString, 5, true);
		}catch(Exception e){
			e.printStackTrace();
		}
		result[0] = nativeBytes;
		result[1] = pureKeyWords(nativeByte);
		//���طִʽ��
		return result;
	}
	
	/**
	 * �ִʽ��д��Ա�ע
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String SegmentWithPos(String sourceString) throws Exception{
		//����ִʽ��
		String result;
		//���зִʣ���NLPIR��ʼ��
		String argu = "";
		//�ַ�����
		String system_charset = "UTF-8";
		int charset_type = 1;
		int init_flag = CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset), charset_type, "1".getBytes(system_charset));
		//����û��Զ���ʵ�		
		AddUserWords("dic/dic.txt");
		
		if(0 == init_flag){
			System.out.println("init fail!");
			return null;
		}
		//����ִʽ��		
		String nativeBytes = null;
		try{
			//�ִ�
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sourceString, 1);
//			System.out.println(nativeBytes);
		}catch(Exception e){
			e.printStackTrace();
		}
		result = nativeBytes;
		//���طִʽ��
		return result;
	}


	/**
	 * ����û��ʵ䲢���д��Ա�ע
	 * @param filePath
	 */
	public static void AddUserWords(String filePath){
		try{
			String encoding = "UTF-8";
			File file = new File(filePath);
			if(file.isFile()&&file.exists()){
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferReader = new BufferedReader(read);
				String lineText = "";
				while((lineText = bufferReader.readLine()) != null){
					CLibrary.Instance.NLPIR_AddUserWord(lineText);
				}
			}
			else{
				System.out.println("δ�ҵ��ļ���");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ����ؼ���
	 * @param source
	 * @return
	 */
	public static String pureKeyWords(String source){
		String keywords[] = source.split("#");
		for(int i = 0; i < keywords.length; i++){
			if(!SYMBOL.isExist(SYMBOL.POS_USE, keywords[i]))
				keywords[i]="";
		}
		String result = "";
		for(int i = 0; i < keywords.length; i++){
			result += keywords[i] + " ";
		}
				
		return result;
		
	}
	
	
}
