package com.luoyuanhang.imaginecup.segment;

import org.python.util.PythonInterpreter;

import com.luoyuanhang.imaginecup.bayes.Bayes;
import com.luoyuanhang.imaginecup.core.Main;
import com.luoyuanhang.imaginecup.utils.PythonInterface;

/**
 * Test类
 * @author Yuanhang Luo
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println("TESTING");
		System.out.println("TESTING");


//------------------------NLPIR测试-------------------------------------------------------
//=======================================================================================	
//*********************************AddUserWords()测试*************************************
//		NLPIR.Segment("test.txt");
//*********************************AddUserWords()测试*************************************
//		NLPIR.AddUserWords("dic/dic.txt");
//*********************************SegmentNoPos()测试*************************************
//		String str[] = NLPIR.SegmentNoPos("目前， 网络通识核心课程选课已结束，选中课程的学生名单将被导入山东大学通识课学习平台，选修课程的学生需按照网络通识核心课程规定的学习及考核办法进行学习和接受考核。学生在学习期间需要按照要求完成以下内容：1.观看课程视频，足量完成听课环节；2.按时完成和提交作业；3.参与课程讨论；4.参与课程答疑；5.参加课程考试。");
//		for(int i= 0; i < str.length; i++){
//			System.out.println(str[i]);
//		}
//=======================================================================================
		
//-------------------------------BUILDXMLDOC测试------------------------------------------
//=======================================================================================
//*********************************build()测试********************************************
//		BUILDXMLDOC.build("test.txt", "target.txt");
//*********************************readXML()测试******************************************
//		BUILDXMLDOC.readXml("test.xml");
//*********************************getSentence()测试**************************************
//		BUILDXMLDOC.pureDoc("test.xml");
		
//=======================================================================================
		
//-------------------------------Bayes测试------------------------------------------------
//=======================================================================================
//*********************************init()测试********************************************
//		Bayes.init();
//		
//=======================================================================================

//---------------------------PythonInterface测试------------------------------------------------
//=======================================================================================
//*********************************python()测试********************************************
//		PythonInterface.python();
//				
//=======================================================================================
		
//--------------------------------Main测试------------------------------------------------
//=======================================================================================
//***************************ProcessByKeyWord()测试****************************************
		System.out.println("YES");
		Main.ProcessByKeyWord("身为上班族每天都要为上班而忙碌，每天要处理的事情太多了，常常因为忘记某件事而烦恼，希望有这么一个软件可以帮助我。在首页可以显示我明天要做的事情的便签，并且我可以随时修改这些便签，这样我就不会忘记了，右上角有显示天气的东西来提醒我明天天气如何，当然偶尔听一下音乐放松一下也是不错的，可以在右下角有一个音乐播放按钮，点击可以打开音乐播放的页面，播放时可以展示一些比较炫的特技啦，哈哈。");
//=======================================================================================


	}
}

















