
import http.HttpResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HttpResponseTest {
    
    @Test
    public void testRespuestasIgualesCabecera() {
        HttpResponse cabecera1 = new HttpResponse(400, "", "HTTP/1.0");
        HttpResponse cabecera2 = new HttpResponse(400, "", "HTTP/1.0");
        assertEquals(cabecera1, cabecera2);

    }
    
    @Test
    public void testRespuestasDiferentesCabecera() {
        HttpResponse cabecera1 = new HttpResponse(400, "", "HTTP/1.0");
        HttpResponse cabecera2 = new HttpResponse(404, "/lala.html", "HTTP/1.0");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasIgualesCabeceraOK() {
        HttpResponse cabecera1 = new HttpResponse(200, "root/index.html", "GET", "HTTP/1.0");
        HttpResponse cabecera2 = new HttpResponse(200, "root/index.html", "GET", "HTTP/1.0");
        assertEquals(cabecera1, cabecera2);

    }
    
    @Test
    public void testRespuestasDiferentesCabeceraOK() {
        HttpResponse cabecera1 = new HttpResponse(200, "root/index.html", "GET", "HTTP/1.0");
        HttpResponse cabecera2 = new HttpResponse(200, "root/diferente.html", "HEAD", "HTTP/1.0");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
    
}
