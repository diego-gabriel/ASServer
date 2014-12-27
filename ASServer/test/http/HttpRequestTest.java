/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Gabriel
 */
public class HttpRequestTest {
    @Test 
    public void HttpRequestConstruction(){
        String clientRequest = "GET /docs/index.html HTTP/1.0\n" +
        "Host: www.test101.com\n" +
        "Accept: image/gif, image/jpeg, */*\n" +
        "Accept-Language: en-us\n" +
        "Accept-Encoding: gzip, deflate\n" +
        "User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)\n" +
        "";
        
        HttpRequest constructedRequest = new HttpRequest(clientRequest);
        HttpRequest expectedRequest = new HttpRequest("GET", "/docs/index.html", "HTTP/1.0");
        
        assertEquals(expectedRequest, constructedRequest);
    }
    
    
    @Test 
    public void HttpRequestConstruction2(){
        String clientRequest = "POST /docs/index.html HTTP/1.0\n" +
        "Host: www.test101.com\n" +
        "Accept: image/gif, image/jpeg, */*\n" +
        "Accept-Language: en-us\n" +
        "Accept-Encoding: gzip, deflate\n" + 
        "User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)\n" +
        "";
        
        HttpRequest constructedRequest = new HttpRequest(clientRequest);
        HttpRequest expectedRequest = new HttpRequest("POST", "/docs/index.html", "HTTP/1.0");
        
        assertEquals(expectedRequest, constructedRequest);
    }
}
