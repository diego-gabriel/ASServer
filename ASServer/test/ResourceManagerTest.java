/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import resourceManager.ResourceManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ResourceManagerTest {
    
    public ResourceManagerTest() {
    }

    @Test
    public void testRecursoExistente() {
        ResourceManager manejador = new ResourceManager();
        boolean respuestaCalculada = manejador.existe("archivos/index.html");
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRecursoNoExistente() {
        ResourceManager manejador = new ResourceManager();
        boolean respuestaCalculada = manejador.existe("archivos/lala.html");
        assertFalse(respuestaCalculada);
    }
    
}
