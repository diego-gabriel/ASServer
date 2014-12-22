package http;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        ResourceManager manager = new ResourceManager();
        File res = manager.getResourceFor(status);
        header = new HttpHeader(status, res.getPath(), protocolVersion);
        if (method.equals("HEAD"))
            resource = null;
        else 
            resource = res;
        
    }
    
    //Constructor cuando el status es exitoso
    public HttpResponse(int status, String resource, String method, String protocolVersion) {
        
        ResourceManager manager = new ResourceManager();
        this.resource = manager.getResource(resource);
        header = new HttpHeader(status, resource, protocolVersion);
        if (method.equals("HEAD"))
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
    
    @Override
    public String toString(){
        String headerStr = this.header.toString();
        String content = "";
        String response = "";
        if (resource != null){
           
            try {
                content = new Scanner(resource).useDelimiter("\\Z").next();
            } catch (FileNotFoundException ex) {
            }
            response = headerStr + "\n\n" + content;
        }
        else
            response = headerStr;
            
        return response;
    }
}
