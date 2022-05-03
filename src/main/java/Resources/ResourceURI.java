package Resources;

public enum ResourceURI {
    REQRES_RESOURCE_URL("/api/users"),
    GO_REST_RESOURCE_URL("/public/v2/users");

    String resourceURl;


    ResourceURI(String resourceURl) {
        this.resourceURl=resourceURl;
    }

    public String getResourceURl(){
        return resourceURl;
    }
}
