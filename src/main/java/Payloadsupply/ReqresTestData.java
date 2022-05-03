package Payloadsupply;

public class ReqresTestData {

    public static String reqResTestData(String name,String job){
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
}
