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
public class CabeceraOKTest {
    
    public CabeceraOKTest() {
    }

    @Test
    public void testCabecerasIguales() {
        CabeceraOK cabecera1 = new CabeceraOK(200, "GET", "archivos/index.html");
        CabeceraOK cabecera2 = new CabeceraOK(200, "GET", "archivos/index.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testCabecerasDiferentes() {
        CabeceraOK cabecera1 = new CabeceraOK(200, "GET", "archivos/index.html");
        CabeceraOK cabecera2 = new CabeceraOK(200, "GET", "archivos/diferente.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
}
