package com.action.library;

import java.io.FileWriter;
import java.io.IOException;

public class StoreSuggestion {
	public void store(String suggestion){
		String fileName="D:/app/suggestionStore/suggestion.txt";
		appendMethod(fileName, suggestion);
		
	}

	public static void appendMethod(String fileName, String content) {  
	    try {  
	        //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�  
	        FileWriter writer = new FileWriter(fileName, true);  
	        writer.write(content);  
	        writer.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}  
}
