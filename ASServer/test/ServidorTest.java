

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ServidorTest {
    
    public ServidorTest() {
    }

    @Test
    public void testParametrosVacios() {
        PeticionHttp peticion = new PeticionHttp("", "", "");
        Servidor servidor = new Servidor();
        RespuestaHttp respuestaCalculada = servidor.getRespuesta(peticion);
        RespuestaHttp respuestaEsperada = new RespuestaHttp(501, "");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testEstado400() {
        PeticionHttp peticion = new PeticionHttp("HEAD", "", "");
        Servidor servidor = new Servidor();
        RespuestaHttp respuestaCalculada = servidor.getRespuesta(peticion);
        RespuestaHttp respuestaEsperada = new RespuestaHttp(400, "");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testEstado404() {
        PeticionHttp peticion = new PeticionHttp("HEAD", "/lala.html", "HTTP/1.0");
        Servidor servidor = new Servidor();
        RespuestaHttp respuestaCalculada = servidor.getRespuesta(peticion);
        RespuestaHttp respuestaEsperada = new RespuestaHttp(404, "/lala.html");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testEstado200() {
        PeticionHttp peticion = new PeticionHttp("GET", "/", "HTTP/1.0");
        Servidor servidor = new Servidor();
        RespuestaHttp respuestaCalculada = servidor.getRespuesta(peticion);
        RespuestaHttp respuestaEsperada = new RespuestaHttp(200, "archivos/index.html", "GET");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
}
