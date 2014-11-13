/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alison Fernandez
 */
public class ValidadorPeticionTest {
    
    public ValidadorPeticionTest() {
    }

    @Test
    public void testPeticionVacia(){
        PeticionHttp peticion = new PeticionHttp("", "", "");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 501;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testMetodoNoImplementado(){
        PeticionHttp peticion = new PeticionHttp("GAT", "/", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 501;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testHeadRecursoPorDefecto(){
        PeticionHttp peticion = new PeticionHttp("HEAD", "/", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testHeadRecursoIndex(){
        PeticionHttp peticion = new PeticionHttp("HEAD", "/index.html", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
   
    
    @Test
    public void testHeadSinRecurso(){
        PeticionHttp peticion = new PeticionHttp("HEAD", "", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 400;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testHeadVersionDistinta(){
        PeticionHttp peticion = new PeticionHttp("HEAD", "/", "HTTP/1.1");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 400;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testHeadRecursoNoExiste(){
        PeticionHttp peticion = new PeticionHttp("HEAD", "/lala.html", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos/");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 404;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testGetRecursoPorDefecto(){
        PeticionHttp peticion = new PeticionHttp("GET", "/", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testGetRecursoIndex(){
        PeticionHttp peticion = new PeticionHttp("GET", "/index.html", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 200;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testGetRecursoVacio(){
        PeticionHttp peticion = new PeticionHttp("GET", "", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 400;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
    @Test
    public void testGetVersionDistinta(){
        PeticionHttp peticion = new PeticionHttp("GET", "/", "HTTP/1.1");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 400;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }

    @Test
    public void testEstadoMetodoGetErrorNoExistePath4(){
        PeticionHttp peticion = new PeticionHttp("GET", "/lala.html", "HTTP/1.0");
        ValidadorPeticion validador = new ValidadorPeticion("archivos");
        int resultadoCalculado = validador.getEstado(peticion);
        int resultadoEsperado = 404;
        assertEquals(resultadoEsperado, resultadoCalculado);
    }
    
}
