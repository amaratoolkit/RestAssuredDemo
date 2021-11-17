package org.tek.APIAutomation;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;


public class WeatherAPIUsingGetRequest {
	
	// get weather request by city 
	@Test
	public void getStatusCode() {
		
		Response resp = given().
						param("id", "524901").
						param("appid","92b7cd2f93befceeb747ce3681981e35").
						when().
						get("https://samples.openweathermap.org/data/2.5/weather");
		
		String report = resp.
						 then().
						 contentType(ContentType.JSON).
						 extract().
						 path("weather[0].description");
		
		System.out.println("response is " + resp);
		
		System.out.println("weather report is " + report);
		
		Float lon = resp.
				 then().
				 contentType(ContentType.JSON).
				 extract().
				 path("coord.lon");
		
		
		
		Float lat = resp.
				 then().
				 contentType(ContentType.JSON).
				 extract().
				 path("coord.lat");
		
		
		
		
		
	System.out.println("longitude is " + lon);
	System.out.println("lattitude is " + lat);
	
		
		
		@SuppressWarnings("deprecation")
		List<Object> reportByLatLon = given().
				param("lat",lat).
				param("lon",lon).
				param("appid","b6907d289e10d714a6e88b30761fae22").
								when().
								get("https://samples.openweathermap.org/data/2.5/forecast/hourly").
								then().
								contentType(ContentType.JSON).
							     extract().jsonPath().getList("list.weather.description");
								 //path("list");
		
		//String resBody = reportByLatLon.asString();
	
		
		System.out.println("result is " + reportByLatLon);
		
	}
}
