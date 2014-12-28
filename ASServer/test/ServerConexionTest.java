import static org.junit.Assert.assertEquals;
import org.junit.Test;
import webServer.ServerConexion;
/**
 *
 * @author Adolfo
 */
public class ServerConexionTest {
    
    @Test
    public void testValidarTipoGet(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarTipo("get");
        assertEquals(true, generado);
    }
    @Test
    public void testValidarTipoHead(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarTipo("head");
        assertEquals(true, generado);
    }
    @Test
    public void testValidarTipoPost(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarTipo("post");
        assertEquals(true, generado);
    }
    
    @Test
    public void testValidarUrlConHttpDosPuntosSlashSlashWwwDireccion(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarUrl("http://www.misitio.com/index.html");
        assertEquals(true, generado);
    }
    
    @Test
    public void testValidarUrlWwwDireccion(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarUrl("www.misitio.com/index.html");
        assertEquals(true, generado);
    }
    
    @Test
    public void testValidarUrlSinWwwDireccion(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarUrl("ins/inicio/index.html");
        assertEquals(true, generado);
    }
    
    @Test
    public void testValidarVersionHttp1dot0(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarUrl("http/1.0");
        assertEquals(true, generado);
    }
    
    @Test
    public void testValidarVersionHttp1dot1(){
        ServerConexion serverConexion = new ServerConexion();
        boolean generado = serverConexion.validarUrl("http/1.1");
        assertEquals(true, generado);
    }
    
    
    @Test
    public void testValidRequest(){
        ServerConexion serverConexion = new ServerConexion();
        String recivedMessage = "get ins/inicio/index.html http/1.0";
        String[] arrayMessage = recivedMessage.trim().split("\\s+");
        
        boolean tipo = serverConexion.validarTipo(arrayMessage[0]);
        boolean url = serverConexion.validarUrl(arrayMessage[1]);
        boolean version = serverConexion.validarVersion(arrayMessage[2]);
        assertEquals(true, tipo&&url&&version);
    }
}