package org.tek.APIAutomation;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetExpertiseData {

//	@Test
	public void testGet() {
		Response resp =	given()
			.when()
			.get("http://localhost:3000/posts/");
		
		System.out.println(resp.asString());
		}
	
	//@Test
	public void getExpertsData() {
		
		Response resp =	given()
				.param("Expertise","Selenium and Appium")
				.get("http://localhost:3000/posts");
		
		System.out.println(resp.asString());
	}
		
	//@Test
	public void getExpertsDataSelenium() {
		
		Response resp =	given()
				.param("Expertise_like","Selenium")
				.get("http://localhost:3000/posts");
		
		System.out.println(resp.asString());
		
		Assert.assertTrue("Selenium not present in response", resp.asString().contains("Slenium"));
	}
	
	public List<Object> resp;
	@Test
	public void getExpertsDataSeleniumIds() {
		
		resp =	given()
				.param("Expertise_like","Selenium")
				.get("http://localhost:3000/posts")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.path("id");
		
		System.out.println(resp);
		
	
	}
	
	@Test(dependsOnMethods= "getExpertsDataSeleniumIds")
	public void postidinProfile() {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		for (int i=0; i<resp.size(); i++) {
			jsonAsMap.put("id"+i,resp.get(i) );
		}
		/*jsonAsMap.put("id", resp.get(0));
		jsonAsMap.put("id", resp.get(1));*/
		//System.out.println("iuhiuhi"+jsonAsMap);
		Response resp = given()
				.body(jsonAsMap)
				.when()
				.contentType(ContentType.JSON)
				.post("http://localhost:3000/profile");
		
		System.out.println("post =====" + resp.asString());
		
		
		
		
	
	}
}
