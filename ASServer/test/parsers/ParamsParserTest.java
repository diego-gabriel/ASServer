
package parsers;

import http.HttpRequest;
import java.util.HashMap;
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
public class ParamsParserTest {
    @Test
    public void testParse1(){
        HashMap<String, String> respuesta = new HashMap<>();
        respuesta.put("uno", "A");
        respuesta.put("dos", "B");
        respuesta.put("tres", "C");
        String req = "POST /index.html HTTP/1.1\n" +
                        "Content-Length: 18\n" +
                        "\n" +
                        "uno=A&dos=B&tres=C";;
        HttpRequest request = new HttpRequest(req);
        ParamsParser parser = new ParamsParser();
        assertEquals(respuesta, parser.parse(request.getParams()));
    }
    @Test
    public void testParse2(){
        HashMap<String, String> respuesta = new HashMap<>();
        respuesta.put("uno", "D");
        respuesta.put("dos", "B");
        respuesta.put("tres", "C");
        String req = "POST /index.html HTTP/1.1\n" +
                        "Content-Length: 18\n" +
                        "\n" +
                        "uno=D&dos=B&tres=C";;
        HttpRequest request = new HttpRequest(req);
        ParamsParser parser = new ParamsParser();
        assertEquals(respuesta, parser.parse(request.getParams()));
    }
    @Test
    public void testParseEmpty(){
        HashMap<String, String> respuesta = new HashMap<>();
        String req = "POST /index.html HTTP/1.1\n" +
                        "\n" +
                        "";
        HttpRequest request = new HttpRequest(req);
        ParamsParser parser = new ParamsParser();
        assertEquals(respuesta, parser.parse(request.getParams()));
    }
    
}
