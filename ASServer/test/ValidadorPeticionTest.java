import http.HttpRequest;
import http.HttpRequestValidator;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValidadorPeticionTest {
    
    public ValidadorPeticionTest() {
    }

    @Test
    public void testPeticionVacia(){
        HttpRequest peticion = new HttpRequest("", "", "");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 501;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testMetodoNoImplementado(){
        HttpRequest peticion = new HttpRequest("GAT", "/", "HTTP/1.0");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 501;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testHeadRecursoPorDefecto(){
        HttpRequest peticion = new HttpRequest("HEAD", "/", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testHeadRecursoIndex(){
        HttpRequest peticion = new HttpRequest("HEAD", "/index.html", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
   
    
    @Test
    public void testHeadSinRecurso(){
        HttpRequest peticion = new HttpRequest("HEAD", "", "HTTP/1.0");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 400;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testHeadVersionDistinta(){
        HttpRequest peticion = new HttpRequest("HEAD", "/", "HTTP/1.0");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 505;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testHeadRecursoNoExiste(){
        HttpRequest peticion = new HttpRequest("HEAD", "/lala.html", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root/");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 404;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testGetRecursoPorDefecto(){
        HttpRequest peticion = new HttpRequest("GET", "/", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testGetRecursoIndex(){
        HttpRequest peticion = new HttpRequest("GET", "/index.html", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testGetRecursoVacio(){
        HttpRequest peticion = new HttpRequest("GET", "", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 400;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testGetVersionDistinta(){
        HttpRequest peticion = new HttpRequest("GET", "/", "HTTP/1.0");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 505;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testEstadoMetodoGetErrorNoExistePath4(){
        HttpRequest peticion = new HttpRequest("GET", "/lala.html", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 404;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testPostOk(){
        HttpRequest peticion = new HttpRequest("POST", "/index.html", "HTTP/1.1");
        HttpRequestValidator validador = new HttpRequestValidator("root");
        int resultadoCalculado = validador.getStatus(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
}
