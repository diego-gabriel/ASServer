package http;


/**
 *
 * @author Alison Fernandez
 */
public class HttpRequest {
    
    private String method;
    private String resource;
    private String version;
    private String DEFAULT_VALUE = "/index.html";
    
    public HttpRequest(String method, String resource, String version){
        this.method = method;
        if(resource.equals("/")){
            resource = DEFAULT_VALUE;
        }
        this.resource = resource;
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    public String getResource() {
        return resource;
    }

    public String getVersion() {
        return version;
    }
}
