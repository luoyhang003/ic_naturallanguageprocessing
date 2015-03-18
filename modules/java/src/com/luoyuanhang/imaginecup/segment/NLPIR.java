package com.luoyuanhang.imaginecup.segment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


//import utils.SystemParas;
import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * 用于分词的类
 * @author Administrator
 *
 */
public class NLPIR {

	//定义JNA接口
	public interface CLibrary extends Library{
		//建立实例
		CLibrary Instance = (CLibrary)Native.loadLibrary("./libs/NLPIR", CLibrary.class);
		//系统初始化
		public int NLPIR_Init(byte[] sDataPath, int encoding,byte[] sLicenceCode);
		//段落处理
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
		//获取关键词
		public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit,boolean bWeightOut);
		//退出函数
		public void NLPIR_Exit();
		//文档处理
		public double NLPIR_FileProcess(String sSourceFilename,String sResultFilename,int bPOStagged);
		//引入用户自定义词典
		public int NLPIR_ImportUserDict(String sFilename,Boolean bOverwrite);
		//添加用户新词并标注词性
		public int NLPIR_AddUserWord(String sWords);
	}
	
	/**
	 * 对一段文字进行分词，返回标注词性的分词结果
	 * 
	 * @param fileName
	 * @return words
	 * @throws Exception
	 */
	public static String[] Segment(String fileName) throws Exception{
		//保存分词结果
		String result[]={"",""};
		String sourceString = "";
		//从文件中读入文本
		try {
            String encoding="UTF-8";
            
            File file=new File(fileName);
            
            if(file.isFile() && file.exists()){ 
            	//判断文件是否存在
            	String temp = null;
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);

                while((temp = bufferedReader.readLine()) != null){
                    sourceString += temp;
                }

                read.close();
            }else{
            	System.out.println("找不到指定的文件");
            }
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		//进行分词，对NLPIR初始化
		String argu = "";
		String system_charset = "UTF-8";
		int charset_type = 1;
		int init_flag = CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset), charset_type, "1".getBytes(system_charset));
		
		CLibrary.Instance.NLPIR_AddUserWord("首页 PAGE");
		
		if(0 == init_flag){
			System.out.println("init fail!");
			return null;
		}
		//保存分词结果		
		String nativeBytes = null;
		//保存关键词
		String nativeByte = null;
		try{
			//分词
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sourceString, 1);
			//获取关键词
			nativeByte = CLibrary.Instance.NLPIR_GetKeyWords(sourceString, 5, true);
		}catch(Exception e){
			e.printStackTrace();
		}
		result[0] = nativeBytes;
		result[1] = nativeByte;
		//返回分词结果
		return result;
	}
	
	
		
	

}
