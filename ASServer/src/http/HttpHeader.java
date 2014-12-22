package http;


public class HttpHeader {
    
    private final int status; 
    private final String protocolVersion;
    private final HttpGeneralHeader generalHeader;
    private final HttpResponseHeader responseHeader;
    private final HttpEntityHeader entityHeader;

    public HttpHeader(int requestStatus, String resource, String protocol){
        status = requestStatus;
        protocolVersion = protocol;
        generalHeader = new HttpGeneralHeader();
        responseHeader = new HttpResponseHeader();
        entityHeader = new HttpEntityHeader(resource);
    }
    
    public HttpHeader(int requestStatus, String protocol){
        status = requestStatus;
        protocolVersion = protocol;
        generalHeader = new HttpGeneralHeader();
        responseHeader = new HttpResponseHeader();
        entityHeader = null;
    }
    
    public int getStatus(){
        return status;
    }
    
    
    @Override
    public String toString(){
        Statusline statusline = new Statusline();
        MiDateFormat date = new MiDateFormat();
        return protocolVersion + " " + statusline.getStatusLine(status) + "\n"
                + generalHeader.toString() + "\n"
                + responseHeader.toString() + "\n"
                + entityHeader.toString();
    }
    
    
    @Override
    public boolean equals(Object other){
        boolean response = false;
        if(other instanceof HttpHeader)
        {
            
            HttpHeader otherHeader = (HttpHeader)other;

            response = status == otherHeader.status && protocolVersion.equals(otherHeader.protocolVersion)
                       && generalHeader.equals(otherHeader.generalHeader) 
                       && responseHeader.equals(otherHeader.responseHeader)
                       && ((entityHeader == null && otherHeader.entityHeader == null) 
                       || (entityHeader != null && otherHeader.entityHeader != null
                       && entityHeader.equals(otherHeader.entityHeader)));
        }
        
        return response;
    }
    
}
