package org.tek.APIAutomation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TestPostRequest {
	
	
	
	@Test(priority =4 )
	public void testGet() {
	Response resp =	given()
		.when()
		.get("http://localhost:3000/posts/");
	
	System.out.println(resp.asString());
	}
	
	@Test(priority = 1)
	public void testPost() {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("id", "7");
		jsonAsMap.put("title", "API Automation");
		jsonAsMap.put("author", "venk");
		
		
		Response resp = given()
				.body(jsonAsMap)
				.when()
				.contentType(ContentType.JSON)
				.post("http://localhost:3000/posts/");
		
		System.out.println("post =====" + resp.asString());
	}
	
	@Test(priority = 2)
	public void testPut() {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("id", "9");
		jsonAsMap.put("title", "Automation Architect");
		jsonAsMap.put("author", "Siva");
		
		
		Response resp = given()
				.body(jsonAsMap)
				.when()
				.contentType(ContentType.JSON)
				.put("http://localhost:3000/posts/9");
		
		System.out.println("put =====" + resp.asString());
	}
	
	
	@Test(priority = 3)
	public void testPatch() {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		
		jsonAsMap.put("Expertise", "Selenium and Appium");
		
		
		
		Response resp = given()
				.body(jsonAsMap)
				.when()
				.contentType(ContentType.JSON)
				.patch("http://localhost:3000/posts/9");
		
		System.out.println("patch =====" + resp.asString());
	}

}
