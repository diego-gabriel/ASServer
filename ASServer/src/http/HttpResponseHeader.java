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
    private MiDateFormat date;
    private String location; //Location: http://www.w3.org/hypertext/WWW/NewLocation.html
    private Statusline statusLine;//"HTTP/" 1*DIGIT "." 1*DIGIT SP 3DIGIT SP
    
                    
    public HttpResponseHeader(){
        server = Server.SERVER_NAME;
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
