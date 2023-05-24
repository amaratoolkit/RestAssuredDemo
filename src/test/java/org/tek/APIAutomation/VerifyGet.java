package org.tek.APIAutomation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
public class VerifyGet {
	@Test
    public void getResponseCode200(){
     Response resp =   given()
                .auth()
                .preemptive()
                .basic("admin", "district")
                .pathParam("dataElementId", "uQZxJ2yjFVE")
                .when()
                .get("https://play.dhis2.org/2.29/dhis-web-maintenance/#/edit/dataElementSection/dataElement/{dataElementId}");
     
     int statusCode = resp .getStatusCode();
     System.out.println(resp.asString());
     
     Assert.assertEquals(statusCode, 200);
    }
	
	//@Test
	public void postData() {
		String baseURI = "https://play.dhis2.org/2.29/dhis-web-maintenance/#/edit/dataElementSection/dataElement/";
		HashMap map = new HashMap();
		
		map.put("Name", "Prashanth");
		map.put("Short name", "pk");
		map.put("Domain type", "Tracker");
		
		Response resp = given()
				.when()
				.contentType(ContentType.JSON)
				.body(map)
				.put(baseURI);
				
		String output = resp.asString();
		
		System.out.println(output);
				
				//typicode
		//npm install -g json-server
		
	}
	
	@Test
	public void testReturnTypeData() {
		String baseURI = "https://play.dhis2.org/2.29/dhis-web-maintenance/#/edit/dataElementSection/dataElement/";
		HashMap map = new HashMap();
		
		map.put("Name", "Prashanth");
		map.put("Short name", "pk");
		map.put("Domain type", "Tracker");
		
		@SuppressWarnings("deprecation")
		RequestSpecification resp = given()
				.when()
				.content(ContentType.JSON.matches("application/json"));
				
				
		String output = resp.toString();
		System.out.println(output);
				
				//typicode
		//npm install -g json-server
		
	}
}
