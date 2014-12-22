/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Gabriel
 */
public class HttpRequestTest {
    @Test
    public void testParamsConstructionPOST(){
        String request = "POST /index.html HTTP/1.1\n" +
                        "Content-Length: 18\n" +
                        "\n" +
                        "uno=A&dos=B&tres=C";
        HttpRequest instance = new HttpRequest(request);
        assertEquals("uno=A&dos=B&tres=C", instance.getParams());
    }
    @Test
    public void testParamsConstructionPOST2(){
        String request = "POST /index.html HTTP/1.1\n" +
                        "Content-Length: 18\n" +
                        "\n" +
                        "uno=A&dos=B&tres=D";
        HttpRequest instance = new HttpRequest(request);
        assertEquals("uno=A&dos=B&tres=D", instance.getParams());
    }
    
    @Test
    public void testParamsConstructionGET(){
        String request = "GET /index.html HTTP/1.1\n";
        HttpRequest instance = new HttpRequest(request);
        assertEquals("", instance.getParams());
    }
    @Test
    public void testParamsConstructionHEAD(){
        String request = "HEAD /index.html HTTP/1.1\n";
        HttpRequest instance = new HttpRequest(request);
        assertEquals("", instance.getParams());
    }
}
