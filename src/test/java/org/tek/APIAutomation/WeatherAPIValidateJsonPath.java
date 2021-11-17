package org.tek.APIAutomation;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class WeatherAPIValidateJsonPath {
	
	// get weather request by city 
	@Test
	public void getWeatherReport() {
		
		Response weatherReport  = given().
						param("id", "2172797").
						param("appid","92b7cd2f93befceeb747ce3681981e35").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");
//						then().
//						contentType(ContentType.JSON).
//						extract().
//						path("weather[0].description");
		
		//System.out.println("weatherReport is " + weatherReport);
		//System.out.println(weatherReport.);
		
		//Assert.assertEquals(weatherReport, "scattered clouds");
	}
}
