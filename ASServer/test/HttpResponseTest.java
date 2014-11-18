/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import http.HttpResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HttpResponseTest {
    
    @Test
    public void testRespuestasIgualesCabecera() {
        HttpResponse cabecera1 = new HttpResponse(400, "");
        HttpResponse cabecera2 = new HttpResponse(400, "");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasDiferentesCabecera() {
        HttpResponse cabecera1 = new HttpResponse(400, "");
        HttpResponse cabecera2 = new HttpResponse(404, "/lala.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasIgualesCabeceraOK() {
        HttpResponse cabecera1 = new HttpResponse(200, "GET", "archivos/index.html");
        HttpResponse cabecera2 = new HttpResponse(200, "GET", "archivos/index.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasDiferentesCabeceraOK() {
        HttpResponse cabecera1 = new HttpResponse(200, "GET", "archivos/index.html");
        HttpResponse cabecera2 = new HttpResponse(200, "HEAD", "archivos/diferente.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
}
