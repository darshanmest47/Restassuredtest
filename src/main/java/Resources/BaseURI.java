package Resources;

public enum BaseURI {

    REQRES_BASE_URI("https://reqres.in");


    String URL;

    BaseURI(String URL) {
        this.URL = URL;
    }

    public String getBaseURL() {
        return URL;
    }
}
