package webServer;


import http.HttpRequest;
import http.HttpRequestValidator;
import http.HttpResponse;


/**
 *
 * @author Alison Fernandez
 */
public class Server {
    
    private String DEFAULT_RAIZ = "archivos";
    
    public HttpResponse getRespuesta(HttpRequest peticion){
        HttpResponse respuesta;
        HttpRequestValidator validador = new HttpRequestValidator(DEFAULT_RAIZ);
        int estadoPeticion = validador.getEstado(peticion);
        
        if(estadoPeticion == 200)
            respuesta = new HttpResponse(estadoPeticion, DEFAULT_RAIZ + peticion.getRecurso(), peticion.getMetodo());
        else
            respuesta = new HttpResponse(estadoPeticion, peticion.getRecurso());
        
        return respuesta;
    }
    
}
