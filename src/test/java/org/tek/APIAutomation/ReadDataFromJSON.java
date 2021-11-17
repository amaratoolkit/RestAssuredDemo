package org.tek.APIAutomation;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {
	public void writeintoJSON(String fileName,String key,String value) throws IOException, ParseException{
		  
		JSONParser parser = new JSONParser();
		  Object obj = parser.parse(new FileReader(fileName));  
		  
		   JSONObject jsonObject = (JSONObject) obj; 

		  FileWriter fileWriter = new FileWriter(fileName);  
		  jsonObject.put(key, value);
		  fileWriter.write(jsonObject.toJSONString());  
	      fileWriter.flush();  
	      fileWriter.close();  
	}

	public static String readJSON(String fileName,String key) throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		  Object obj = parser.parse(new FileReader(fileName));  
			JSONObject jsonObject = (JSONObject) obj;

			String keyValue = (String) jsonObject.get(key);
			

		return keyValue;
	}
}
