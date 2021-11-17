package org.tek.APIAutomation;


import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VerifyPost {
    HashMap map = new HashMap();
    JSONObject a;
    String json;

    @BeforeSuite
    public void initializeURL() {
        RestAssured.baseURI="https://play.dhis2.org/2.29/api/29/";
    }

    @BeforeTest
    public void dataSetUp(){

        map.put("dataElements", true);
        map.put("valueType", "TEXT");
        map.put("name", "Hyderabad2");
        RestAssured.basePath="attributes";
    }
    @Test
    public void testPost(){
    given()
            .contentType("application/json")
            .auth()
            .preemptive()
            .basic("admin", "district")
            .body(map)
            .when()
            .post()
            .then()
            .statusCode(201)
            .and()
            .assertThat()
            .body("httpStatus",equalTo("Created"));

    }
}
