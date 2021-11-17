package org.tek.APIAutomation;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class WeatherAPIUsingParams {
	
	// get weather request by city 
//	@Test
	public void getStatusCode() {
		
		Response resp = given().
						param("q", "London").
						param("appid", "b6907d289e10d714a6e88b30761fae22").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");
		
		int code = resp.getStatusCode();
		
		System.out.println("status code is " + code);
		
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void getStatusCodeUsingAssert() {
		
		ValidatableResponse resp = given().
						param("q", "London").
						param("appid", "b6907d289e10d714a6e88b30761fae22").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather").
						then().
						assertThat().statusCode(200);
		
		//int code = resp.getStatusCode();
		
		//System.out.println("status code is " + code);
		
	//	Assert.assertEquals(code, 200);
	}
	


}
