package com.luoyuanhang.imaginecup.core;

import com.luoyuanhang.imaginecup.segment.NLPIR;
import com.officecoder.xml.XMLWorker;

/**
 * 
 * @author Administrator
 *
 */
public class Main {
	public static void ProcessByKeyWord(String str) throws Exception{
		String result = NLPIR.Segment(str)[1];
//		XMLWorker worker = new XMLWorker("UUID", "PROJECT_NAME");
//		worker.addFullPage(result);
		System.out.println(result);
	}

}
