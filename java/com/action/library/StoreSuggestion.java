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
	        //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
	        FileWriter writer = new FileWriter(fileName, true);  
	        writer.write(content);  
	        writer.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}  
}
