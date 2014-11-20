/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import http.HttpHeader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HeaderTest {
    
    public HeaderTest() {
    }

    @Test
    public void testCabecerasIguales() {
        HttpHeader cabecera1 = new HttpHeader(404, "/lala.html");
        HttpHeader cabecera2 = new HttpHeader(404, "/lala.html");
        assertEquals(cabecera1, cabecera2);
    }
    
    @Test
    public void testCabecerasDiferentes() {
        HttpHeader cabecera1 = new HttpHeader(404, "/lala.html");
        HttpHeader cabecera2 = new HttpHeader(400, "");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
}
