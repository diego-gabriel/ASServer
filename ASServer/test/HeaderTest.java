/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Header cabecera1 = new Header(404, "/lala.html");
        Header cabecera2 = new Header(404, "/lala.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testCabecerasDiferentes() {
        Header cabecera1 = new Header(404, "/lala.html");
        Header cabecera2 = new Header(400, "");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
}
