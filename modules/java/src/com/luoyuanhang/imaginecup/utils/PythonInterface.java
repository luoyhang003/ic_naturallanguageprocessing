package com.luoyuanhang.imaginecup.utils;


import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;


public class PythonInterface {
	public static void python()throws Exception{
		Runtime.getRuntime().exec("python E:\\ic_naturallanguageprocessing\\modules\\java\\bayes.py");
		
//		PythonInterpreter interpreter = new PythonInterpreter();
//		interpreter.execfile("E:\\ic_naturallanguageprocessing\\modules\\java\\bayes.py");
	}
}
