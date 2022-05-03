package org.tests;

import Helpermethods.Helperclass;
import Payloadsupply.ReqresTestData;
import Resources.BaseURI;
import Resources.ResourceURI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    String response = "";
    String postResponse="";

    @Test(priority = 0)
    public void reqResPage1Test() {
        RestAssured.baseURI = BaseURI.REQRES_BASE_URI.getBaseURL();
        response = given().log().all().queryParam("page", "1")
                .when().get(ResourceURI.REQRES_RESOURCE_URL.getResourceURl())
                .then().log().all().assertThat().statusCode(200).header("X-Powered-By",equalTo("Express"))
                .body("total",equalTo(12))
                .body("per_page",equalTo(6))
                .extract().response().asString();


    }

    @Test(priority = 1,dependsOnMethods = "reqResPage1Test",dataProvider = "userEmails" )
    public void reqResPage1PrintEmailsTest(String email){
        JsonPath js = Helperclass.getJSonPath(response);
        int dataSize = js.getInt("data.size()");
        for(int i=0;i<dataSize;i++){
            if(js.getString("data["+i+"].email").equalsIgnoreCase(email)){
                System.out.println(js.getString("data["+i+"].email")+" was found in position "+js.getString("data["+i+"].id"));
                break;
            }



        }

    }


    @Test(priority = 1,dataProvider = "userData")
    public void reqResPostDataTest(String name,String job){
        RestAssured.baseURI = BaseURI.REQRES_BASE_URI.getBaseURL();
       postResponse = given().log().all().header("content-type","application/json")
                .body(ReqresTestData.reqResTestData(name,job))
                .when().post(ResourceURI.REQRES_RESOURCE_URL.getResourceURl())
                .then().log().all().assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath js = Helperclass.getJSonPath(postResponse);
        System.out.println(js.getString("name"));
        System.out.println(js.getString("job"));
        System.out.println(js.getString("id"));
        System.out.println(js.getString("createdAt"));



    }


    @DataProvider
    public String[] userEmails() {
        return new String[]{"tracey.ramos@reqres.in","charles.morris@reqres.in","emma.wong@reqres.in","eve.holt@reqres.in","janet.weaver@reqres.in","george.bluth@reqres.in"};
    }

    @DataProvider
    public String[][] userData(){
        String[][] userdata = {{"Darshan","sdet1"},{"Suraj","sdet1"}};
        return userdata;
    }
}




