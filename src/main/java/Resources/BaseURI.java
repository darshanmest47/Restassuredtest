package Resources;

public enum BaseURI {

    REQRES_BASE_URI("https://reqres.in"),
    GO_REST_BASE_URI("https://gorest.co.in");


    String URL;

    BaseURI(String URL) {
        this.URL = URL;
    }

    public String getBaseURL() {
        return URL;
    }
}
