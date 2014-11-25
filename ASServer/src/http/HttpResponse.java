package http;


/**
 *
 * @author Alison Fernandez
 */
public class HttpResponse {
    
    private final HttpHeader header;
    //Constructor de HttpResponse cuando ocurre un error
    public HttpResponse(int status, String method, String protocolVersion){
        header = new HttpHeader(status, protocolVersion);
    }
    
    //Constructor cuando el status es exitoso
    public HttpResponse(int status, String resource, String method, String protocolVersion) {
        
        header = new HttpHeader(status, resource, protocolVersion);
    }
    
    @Override
    public boolean equals(Object anotherResponse){
        boolean response = false;
        
        if(anotherResponse instanceof HttpResponse)
        {
            HttpHeader anotherHeader = ((HttpResponse)anotherResponse).header;
            response = anotherHeader.equals(header);
        }
        
        return response;
    }
}
