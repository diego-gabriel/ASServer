/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
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
        boolean respuestaCalculada = manejador.existe("root/index.html");
        assertTrue(respuestaCalculada);
    }@Test
    public void testRecursoExistenteSinExtension() {
        ResourceManager manejador = new ResourceManager();
        boolean respuestaCalculada = manejador.existe("root/index");
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRecursoNoExistente() {
        ResourceManager manejador = new ResourceManager();
        boolean respuestaCalculada = manejador.existe("root/lala.html");
        assertFalse(respuestaCalculada);
    }
    
    @Test
    public void testGetResourceFor_400Succedd(){
        File expectedResult = new File("root/errorFile/400.html");
        ResourceManager manager = new ResourceManager();
        File result = manager.getResourceFor(400);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testGetResourceFor_404Succedd(){
        File expectedResult = new File("root/errorFile/404.html");
        ResourceManager manager = new ResourceManager();
        File result = manager.getResourceFor(404);
        assertEquals(expectedResult, result);
    }
    
    
    @Test
    public void testGetResourceFor_Fail(){
        File expectedResult = new File("root/errorFile/100.html");
        ResourceManager manager = new ResourceManager();
        File result = manager.getResourceFor(100);
        assertEquals(expectedResult, result);
    }
    
    
    @Test 
    public void getResource_OK(){
        File expectedResult = new File("root/index.html");
        ResourceManager manager = new ResourceManager();
        assertEquals(expectedResult, manager.getResource("root/index.html"));
    }
    @Test 
    public void getResource_OK2(){
        File expectedResult = new File("root/diferente.html");
        ResourceManager manager = new ResourceManager();
        assertEquals(expectedResult, manager.getResource("root/diferente.html"));
    }
}
