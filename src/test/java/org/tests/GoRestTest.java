package org.tests;

import Payloadsupply.GoRestTestData;
import Resources.BaseURI;
import Resources.ResourceURI;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoRestTest {


    @Test(priority = 0)
    public void goRestGetTest(){
        RestAssured.baseURI = BaseURI.GO_REST_BASE_URI.getBaseURL();

      given().log().all().header("content-type","application/json").when().get(ResourceURI.GO_REST_RESOURCE_URL.getResourceURl())
              .then().log().all().assertThat().statusCode(200);
    }


//    @Test(priority = 1,dataProvider = "goresttestdata")
//    public void goRestPostTest(String name,String gender ,String email,String status){
//        RestAssured.baseURI = BaseURI.GO_REST_BASE_URI.getBaseURL();
//
//        given().log().all().header("content-type","application/json")
//                .body(GoRestTestData.goRestPostData(name,gender,email,status))
//                .when().post(ResourceURI.GO_REST_RESOURCE_URL.getResourceURl())
//                .then().log().all().assertThat().statusCode(401);
//    }


    @DataProvider(name = "goresttestdata")
    public String[] returnGoRestTestData(){
        return new String[]{"Darshan","male","darshan@test.com","active"};
    }

}
