package Payloadsupply;

public class GoRestTestData {


    public static String goRestPostData(String name,String gender,String email,String status){
        return "{\"name\":\""+name+"\", \n" +
                "\"gender\":\""+gender+"\",\n" +
                " \"email\":\""+email+"\",\n" +
                "  \"status\":\""+status+"\"}";
    }
}
