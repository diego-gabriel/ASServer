package http;

import java.io.File;

import resourceManager.ResourceManager;

/**
 *
 * @author Alison Fernandez
 */
public class HttpResponse {
    
    private final HttpHeader header;
    private File resource;
    //Constructor de HttpResponse cuando ocurre un error
    public HttpResponse(int status, String method, String protocolVersion){
        header = new HttpHeader(status, protocolVersion);
        if (!method.equals("HEAD")){
            ResourceManager manager = new ResourceManager();
            resource = manager.getResourceFor(status);
        }
        else
            resource = null;
    }
    
    //Constructor cuando el status es exitoso
    public HttpResponse(int status, String resource, String method, String protocolVersion) {
        
        header = new HttpHeader(status, resource, protocolVersion);
        if (!method.equals("HEAD")){
            ResourceManager manager = new ResourceManager();
            this.resource = manager.getResource(resource);
        }
        else
            this.resource = null;
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
