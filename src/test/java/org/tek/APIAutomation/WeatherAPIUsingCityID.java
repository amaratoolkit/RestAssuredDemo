package org.tek.APIAutomation;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class WeatherAPIUsingCityID {
	
	// get weather request by city 
	@Test
	public void getStatusCode() {
		
		Response resp = given().
						param("id", "2172797").
						param("appid","92b7cd2f93befceeb747ce3681981e35").
				
				
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");
		
		int code = resp.getStatusCode();
		
		System.out.println("status code is " + code);
		
		Assert.assertEquals(code, 200);
	}
}
