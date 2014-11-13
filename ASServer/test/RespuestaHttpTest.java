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
public class RespuestaHttpTest {
    
    @Test
    public void testRespuestasIgualesCabecera() {
        RespuestaHttp cabecera1 = new RespuestaHttp(400, "");
        RespuestaHttp cabecera2 = new RespuestaHttp(400, "");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasDiferentesCabecera() {
        RespuestaHttp cabecera1 = new RespuestaHttp(400, "");
        RespuestaHttp cabecera2 = new RespuestaHttp(404, "/lala.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasIgualesCabeceraOK() {
        RespuestaHttp cabecera1 = new RespuestaHttp(200, "GET", "archivos/index.html");
        RespuestaHttp cabecera2 = new RespuestaHttp(200, "GET", "archivos/index.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertTrue(respuestaCalculada);
    }
    
    @Test
    public void testRespuestasDiferentesCabeceraOK() {
        RespuestaHttp cabecera1 = new RespuestaHttp(200, "GET", "archivos/index.html");
        RespuestaHttp cabecera2 = new RespuestaHttp(200, "HEAD", "archivos/diferente.html");
        boolean respuestaCalculada = cabecera1.equals(cabecera2);
        assertFalse(respuestaCalculada);
    }
    
}
