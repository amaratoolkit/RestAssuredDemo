package org.tek.APIAutomation;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VerifyDelete {

    @BeforeSuite
    public void initializeURL() {
        RestAssured.baseURI="https://play.dhis2.org/2.29/dhis-web-maintenance/#/edit/dataElementSection/dataElement/";
        RestAssured.basePath = "attributes";
    }

    @Test
    public  void testDelete(){
        given()
                .contentType("application/json")
                .auth()
                .preemptive()
                .basic("admin", "district")

                .when()
                .delete("cYeuwXTCPkU")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("httpStatus",equalTo("OK"));

        given()
                .contentType("application/json")
                .auth()
                .preemptive()
                .basic("admin", "district")
                .when()
                .get(RestAssured.baseURI+RestAssured.basePath+"cYeuwXTCPkU")
                .then()
                .statusCode(404);
    }
}
