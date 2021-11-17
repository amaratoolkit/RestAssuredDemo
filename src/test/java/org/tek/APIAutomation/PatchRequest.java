package org.tek.APIAutomation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PatchRequest {

	@Test
	public void testPatch() {
		Response resp = given().
						body("{\"title\" : \"QA Automation Expert\"}").
						when().
						contentType(ContentType.JSON).
						patch("http://localhost:3000/posts/9");
						
		String result = resp.asString();

		System.out.println(result);
	}
}
