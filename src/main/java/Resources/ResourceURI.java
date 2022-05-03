package Resources;

public enum ResourceURI {
    REQRES_RESOURCE_URL("/api/users");

    String resourceURl;


    ResourceURI(String resourceURl) {
        this.resourceURl=resourceURl;
    }

    public String getResourceURl(){
        return resourceURl;
    }
}
