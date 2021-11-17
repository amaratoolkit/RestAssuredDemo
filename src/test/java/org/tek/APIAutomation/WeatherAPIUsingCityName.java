package org.tek.APIAutomation;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.restassured.response.Response;


public class WeatherAPIUsingCityName {
	
	// get weather request by city 
	@Test
	public void getStatusCode() throws FileNotFoundException, IOException, ParseException {
		
		Response resp = when().
						get("https://samples.openweathermap.org/data/2.5/weather?q=London");
		
		int code = resp.getStatusCode();
		
		System.out.println("status code is " + code);
		
		Assert.assertEquals(code,Integer.parseInt(ReadJSONData.readData("weather", "responses")));
	}
	
	@Test
	public void getData() throws FileNotFoundException, IOException, ParseException {
		
		Response resp = when().
						get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		String data = resp.asString();
		
		System.out.println("data is " + data);
		System.out.println("-------------------------------");
		System.out.println(ReadJSONData.readData("weather", "description"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(data.contains(ReadJSONData.readData("weather", "description")));
		//Assert.(data, ReadJSONData.readData("weatherData", "coord"));
		
	
	}
	
	@Test
	public void getTime() {
		
		Response resp = when().
						get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		long time = resp.getTime();
		
		System.out.println("time is " + time);
		
	}

}
