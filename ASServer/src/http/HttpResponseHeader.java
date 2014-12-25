package http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import webServer.Server;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponseHeader {
    private final String server;
    private String location; //Location: http://www.w3.org/hypertext/WWW/NewLocation.html
    
                    
    public HttpResponseHeader(){
        server = Server.SERVER_NAME;
    }
    
    @Override
    public String toString(){
        return "Location: " + location + "\n"
                + "Server: " + server;
    }
      
    public boolean equals(HttpResponseHeader other){
        return server.equals(other.server);
    }
    public boolean isValidLocation(String absoluteURI){
        String pattern = "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(absoluteURI);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }
}
