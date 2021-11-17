package org.tek.APIAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONData {

	@SuppressWarnings("unchecked")
	public static String readData(String key, String value) throws FileNotFoundException, IOException, ParseException {
		String keyValue = null;
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("employees.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;
			//System.out.println(employeeList);

			// Iterate over employee array
			// employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
			//employeeList.forEach(emp -> getData((JSONObject) emp, key, value));
			
			for(Object emp: employeeList) {
				keyValue = getData((JSONObject) emp, key, value);
			}
			

		}
		return keyValue;
		
	}

	public static String getData(JSONObject employee, String key, String value) {
		// Get employee object within list
		JSONObject employeeObject = (JSONObject) employee.get(key);

		// Get employee first name
		String firstName = (String) employeeObject.get(value);
		//System.out.println(firstName);
		return firstName;
	}
	
	@SuppressWarnings("unchecked")
	public static String getValue(String key, String value) {
		String keyValue= null;
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("employees.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(new FileReader("employees.json"));  
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray jSonArray = (JSONArray) obj;
			
			for(Object array: jSonArray) {
				JSONObject jsonObj = (JSONObject) jsonObject.get(key);
				
				keyValue = (String) jsonObj.get(value);
				
			}
				

				

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return keyValue;
								
			
			
			
		
	}
}
