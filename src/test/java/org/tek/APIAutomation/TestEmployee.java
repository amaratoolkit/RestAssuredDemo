package org.tek.APIAutomation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class TestEmployee {

	//@Test
	public void testGet() {
	Response resp =	given()
		.when()
		.get("http://dummy.restapiexample.com/api/v1/employees");
	
	System.out.println(resp.asString());
	System.out.println("******************************************************");
//	JsonPath jsonPathEvaluator = resp.jsonPath();
//	String emp_name = jsonPathEvaluator.get("/data/id");
//	System.out.println("emp_name" + emp_name);
	resp.then().contentType(ContentType.JSON).extract().path("data.employee_name[1]");
	System.out.println("data======"+ resp.then().contentType(ContentType.JSON).extract().path("data.employee_name[1]"));

	}
	
	@Test
	public void testGetEmployee() {
	Response resp =	given().
					when().
					get("https://api.spacexdata.com/v4/launches/latest");
	
	System.out.println(resp.asString());
	
//	ValidatableResponse shipId123 = resp.then().assertThat().contentType("application/json");
//	ExtractableResponse<Response> shipId1234 = resp.then().contentType(ContentType.JSON).extract();
//	
//	System.out.println("Ship Id123 ======"+ shipId123);
//	
//	System.out.println("Ship Id1234 ======"+ shipId1234);


	ValidatableResponse shipId123 = resp
			.then().contentType(ContentType.JSON);
			//.contentType("application/json");
	System.out.println("Ship Id123 ======"+ shipId123);
	
	ArrayList shipId = resp
					.then().contentType(ContentType.JSON).extract().path("fairings.ships");
	
	System.out.println("Ship Id ======"+ shipId);
	
	ArrayList shipIdExpected = new ArrayList();
	shipIdExpected.add("5ea6ed2e080df4000697c908");
	
	System.out.println("shipIdExpected======"+ shipIdExpected);
	
	Assert.assertEquals(shipId, shipIdExpected);
	
	
	String image = resp
			.then().contentType(ContentType.JSON).extract().path("links.patch.large");
	System.out.println("image======"+ image);
	
	String media = resp
			.then().contentType(ContentType.JSON).extract().path("links.reddit.media");
		
	System.out.println("media========="+ media);
	
	
	ArrayList allShipIds = resp.then().contentType(ContentType.JSON).extract().path("ships");
	System.out.println("al======"+ allShipIds);
	
	Arrays.asList(allShipIds).containsAll(Arrays.asList(shipId));
	
	Arrays.asList(shipId).containsAll(Arrays.asList(allShipIds));
	
	System.out.println("return assert value ===== " + Arrays.asList(allShipIds).contains(shipId));
	
	System.out.println("return aseert ========" +  Arrays.asList(shipId).containsAll(Arrays.asList(allShipIds)));
	
	ArrayList landingType = resp
			.then().contentType(ContentType.JSON).extract().path("cores.landing_type");
	
	System.out.println("landingType====="+ landingType);
	
	ArrayList landingAttempt = resp
			.then().contentType(ContentType.JSON).extract().path("cores.landing_attempt");
	
	System.out.println("landingAttempt====="+ landingAttempt);
	
	ArrayList cores = resp.then().contentType(ContentType.JSON).extract().jsonPath().get("cores");
	
	System.out.println("cores======"+ cores);
	}
}
