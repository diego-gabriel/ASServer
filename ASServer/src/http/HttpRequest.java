package http;


/**
 *
 * @author Alison Fernandez
 */
public class HttpRequest {
    
    private String method;
    private String resource;
    private String version;
    private String params;
    private String DEFAULT_VALUE = "/index.html";
    
    public HttpRequest(String clientRequest){
        String[] requestLines = clientRequest.split("\n");
        String[] requestLine = requestLines[0].split(" ");
        this.method = requestLine[0];
        this.resource = normalizeResource(requestLine[1]);
        this.version = requestLine[2];
        
        if (method.equals("POST")){
            String[] requestParts = clientRequest.split("\n\n");
            if (requestParts.length >= 2)
                params = requestParts[1];
            else 
                params = "";
        }
        else
            params = "";
    }
    
    public HttpRequest(String method, String resource, String version){
        this.method = method;
        this.resource = normalizeResource(resource);
        this.version = version;
    }
    
    private String normalizeResource(String resource){
        
        if(resource.equals("/")){
            resource = DEFAULT_VALUE;
        }
        
        return resource;
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
    
    public String getParams(){
        return params;
    }
    
    @Override
    public boolean equals(Object anObject){
        if (anObject instanceof HttpRequest){
            HttpRequest aRequest = (HttpRequest) anObject;
            
            return method.equals(aRequest.method) &&
                   resource.equals(aRequest.resource) &&
                   version.equals(aRequest.version) &&
                   params.equals(aRequest.params);
        }
        
        return false;
    }
}
