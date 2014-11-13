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
public class ManejadorArchivoTest {
    
    public ManejadorArchivoTest() {
    }

    @Test
    public void testRecursoExistente() {
        ManejadorArchivo manejador = new ManejadorArchivo();
        boolean respuestaCalculada = manejador.existe("archivos/index.html");
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRecursoNoExistente() {
        ManejadorArchivo manejador = new ManejadorArchivo();
        boolean respuestaCalculada = manejador.existe("archivos/lala.html");
        assertFalse(respuestaCalculada);
    }
    
}
