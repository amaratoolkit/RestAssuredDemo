package org.tek.APIAutomation;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;


public class JsonServerRequests {
	
	@Test
	public void requestServer() {
		Response resp = given().
						when().
						get("http://localhost:3000/posts");
		
		String result = resp.asString();
		
		System.out.println(result);
	}

	@Test
	public void postReqServer() {
		Response resp = given().
						body("{\"id\":\"7\", \"title\":\"teksystem\"}").
						when().
						contentType(ContentType.JSON).
						post("http://localhost:3000/posts");
						
						
		
		String result = resp.asString();
		
		System.out.println(result);
	}
	
}
