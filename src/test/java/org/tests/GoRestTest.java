package org.tests;

import Resources.BaseURI;
import Resources.ResourceURI;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

public class GoRestTest {


    @Test(priority = 0)
    public void goRestGetTest(){
        RestAssured.baseURI = BaseURI.GO_REST_BASE_URI.getBaseURL();

      given().log().all().header("content-type","application/json").when().get(ResourceURI.GO_REST_RESOURCE_URL.getResourceURl())
              .then().log().all().assertThat().statusCode(200);
    }

}
