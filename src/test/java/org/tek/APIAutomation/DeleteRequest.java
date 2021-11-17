package org.tek.APIAutomation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class DeleteRequest {

	@Test
	public void testDelete() {
		Response resp = given().
						when().
						contentType(ContentType.JSON).
						delete("http://localhost:3000/posts/1");
						
		String result = resp.asString();

		System.out.println(result);
	}
}
