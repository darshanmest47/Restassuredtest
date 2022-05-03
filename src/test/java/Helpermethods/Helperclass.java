package Helpermethods;

import io.restassured.path.json.JsonPath;

public final class Helperclass {

    private Helperclass(){

    }

    public static JsonPath getJSonPath(String response){
        JsonPath js = new JsonPath(response);
        return js;

    }
}
