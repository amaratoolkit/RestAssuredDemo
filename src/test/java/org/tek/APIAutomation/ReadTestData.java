package org.tek.APIAutomation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class ReadTestData {
	
	 
	    @SuppressWarnings("unchecked")
	    public static void main(String[] args)
	    {
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader reader = new FileReader("employees.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray employeeList = (JSONArray) obj;
	            System.out.println(employeeList);
	             
	            //Iterate over employee array
	          //  employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
	            employeeList.forEach( emp -> getData( (JSONObject) emp ,"responses", "responseCode") );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private static void getData(JSONObject employee, String key, String value)
	    {
	        //Get employee object within list
	        JSONObject employeeObject = (JSONObject) employee.get(key);
	         
	        //Get employee first name
	        String firstName = (String) employeeObject.get(value);   
	        System.out.println(firstName);
	         
	       
	    }
	 
	    private static void parseEmployeeObject(JSONObject employee)
	    {
	        //Get employee object within list
	        JSONObject employeeObject = (JSONObject) employee.get("employee");
	         
	        //Get employee first name
	        String firstName = (String) employeeObject.get("firstName");   
	        System.out.println(firstName);
	         
	        //Get employee last name
	        String lastName = (String) employeeObject.get("lastName"); 
	        System.out.println(lastName);
	         
	        //Get employee website name
	        String website = (String) employeeObject.get("website");   
	        System.out.println(website);
	    }
	
}
