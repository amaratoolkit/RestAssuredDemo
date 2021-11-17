package org.tek.APIAutomation;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

public class PostRequest {
	//public PostsTest post;

	//@Test
	public void testPostReq() {
		PostsTest post = new PostsTest();
		post.setId("10");
		post.setTitle("Automation");
		post.setAuthor("Yogesh");
		
		Map<String, Object>  jsonAsMap = new HashMap<>();
		//jsonAsMap.put("id", "10");
		jsonAsMap.put("title", "Automation");
		jsonAsMap.put("author", "Siva");
		
		Response resp = given().
						when().
						contentType(ContentType.JSON).
						body(post).
						post("http://localhost:3000/posts");

		String result = resp.asString();

		System.out.println(result);
	}
	
	//@Test
	public void testGetReq() {
				
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("id", "10");
		jsonAsMap.put("title", "Automation");
		jsonAsMap.put("author", "Siva");
		
		Response resp = given().
						when().
						get("http://localhost:3000/posts/10");

		String result = resp.asString();

		System.out.println(result);
	}
}
