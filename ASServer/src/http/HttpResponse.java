package http;


/**
 *
 * @author Alison Fernandez
 */
public class HttpResponse {
    
    private final HttpHeader header;
    
    public HttpResponse(int status, String method, String protocolVersion){
        header = new HttpHeader(status, protocolVersion);
    }

    public HttpResponse(int status, String resource, String method, String protocolVersion) {
        
        header = new HttpHeader(status, resource, protocolVersion);
    }
    
    @Override
    public boolean equals(Object anotherRersponse){
        boolean response = false;
        if(anotherRersponse instanceof HttpResponse)
        {
            Object anotherHeader = ((HttpResponse)anotherRersponse).header;
            response = anotherHeader.equals(header);
        }
        
        return response;
    }
}
