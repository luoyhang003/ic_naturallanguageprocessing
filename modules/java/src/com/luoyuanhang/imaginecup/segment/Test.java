package com.luoyuanhang.imaginecup.segment;

/**
 * Test��
 * @author Yuanhang Luo
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println("TESTING");

//------------------------NLPIR����------------------------------
//=====================================================================	
//*********************************AddUserWords()����*************************************
		NLPIR.Segment("test.txt");
//*********************************AddUserWords()����*************************************
//		NLPIR.AddUserWords("dic/dic.txt");
//===================================================================================
		
//-------------------------------BUILDXMLDOC����-----------------------------------------
//=============================================================================================
//*********************************build()����********************************************
		BUILDXMLDOC.build("test.txt", "target.txt");
//*********************************readXML()����******************************************
//		BUILDXMLDOC.readXml("test.xml");
//*********************************getSentence()����**************************************
//		BUILDXMLDOC.pureDoc("test.xml");
		
//=============================================================================================
	}
}

















