package org.tek.APIAutomation;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestData {
	
	  public String getJsonData(String filePath) {
	        try {
	        ObjectMapper m = new ObjectMapper();
	        JsonNode rootNode = m.readTree(new File(filePath));
	        return rootNode.toString();
	        }catch (Exception e){
	            System.err.println("Something wrong with specified file: "+filePath);
	            return null;
	        }
	    }
	  

	  @Test
	  public void testDataFromJson() {
		  
		  System.out.println(getJsonData(System.getProperty("user.dir")+ "/testData.json"));
	  }
	  
	  
}
