package org.tek.APIAutomation;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest {

	
//	@Test
	public void getRequest() {
		Response resp = given()
						.when()
						.get("http://localhost:3000/posts");
		
		System.out.println("Result ==  "+ resp.asString());
	}
	//@Test
	public void testPostReq() {
		
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("id", "10");
		jsonAsMap.put("title", "Automation");
		jsonAsMap.put("author", "Yogesh Kunche");
		
		Response resp = given().
						when().
						contentType(ContentType.JSON).
						body(jsonAsMap).
						put("http://localhost:3000/posts/10");

		String result = resp.asString();
		
		int results = resp.getStatusCode();

		System.out.println(results);
		System.out.println(result);
	}
	
}

