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
		//
		public int NLPIR_GetParagraphProcessAWordCount(String sParagraph);

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
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);
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
		result[1] = nativeByte;
		//���طִʽ��
		return result;
	}
	
	
		
	

}
