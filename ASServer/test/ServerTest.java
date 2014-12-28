
import http.HttpHeader;
import webServer.Server;
import http.HttpRequest;
import http.HttpResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ServerTest {
    
    public ServerTest() {
    }

    @Test
    public void testParametrosVacios() {
        HttpRequest peticion = new HttpRequest("", "", "");
        Server servidor = new Server();
        HttpResponse respuestaCalculada = servidor.getRespuesta(peticion);
        HttpResponse respuestaEsperada = new HttpResponse(501, "", "");
        assertEquals(respuestaEsperada, respuestaCalculada);
        
    }
    
    @Test
    public void testEstado400() {
        HttpRequest peticion = new HttpRequest("HEAD", "", "");
        Server servidor = new Server();
        HttpResponse respuestaCalculada = servidor.getRespuesta(peticion);
        HttpResponse respuestaEsperada = new HttpResponse(400, "HEAD", "");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testEstado404() {
        HttpRequest peticion = new HttpRequest("HEAD", "/lala.html", "HTTP/1.1");
        Server servidor = new Server();
        HttpResponse respuestaCalculada = servidor.getRespuesta(peticion);
        HttpResponse respuestaEsperada = new HttpResponse(404, "HEAD", "HTTP/1.1");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testEstado200() {
        HttpRequest peticion = new HttpRequest("GET", "/", "HTTP/1.1");
        Server servidor = new Server();
        HttpResponse respuestaCalculada = servidor.getRespuesta(peticion);
        HttpResponse respuestaEsperada = new HttpResponse(200, "root/index.html", "GET", "HTTP/1.1");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testEstado505() {
        HttpRequest peticion = new HttpRequest("GAT", "/", "HTTP/1.1");
        Server servidor = new Server();
        HttpResponse respuestaCalculada = servidor.getRespuesta(peticion);
        HttpResponse respuestaEsperada = new HttpResponse(501, "GAT", "HTTP/1.1");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
  
}
