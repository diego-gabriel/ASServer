
package http;

import java.time.Instant;
import java.util.Date;


public class HttpGeneralHeader {
    private final String date;
    
    public HttpGeneralHeader(){
        Date now = new Date();
        date = now.toString();
    }
    
    public boolean equals(HttpGeneralHeader other){
        return date.equals(other.date);
    }
}
