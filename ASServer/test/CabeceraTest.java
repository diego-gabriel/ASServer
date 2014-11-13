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
public class CabeceraTest {
    
    public CabeceraTest() {
    }

    @Test
    public void testCabecerasIguales() {
        Cabecera cabecera1 = new Cabecera(404, "/lala.html");
        Cabecera cabecera2 = new Cabecera(404, "/lala.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testCabecerasDiferentes() {
        Cabecera cabecera1 = new Cabecera(404, "/lala.html");
        Cabecera cabecera2 = new Cabecera(400, "");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
}
