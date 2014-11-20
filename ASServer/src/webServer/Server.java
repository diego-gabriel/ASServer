package webServer;


import http.HttpRequest;
import http.HttpRequestValidator;
import http.HttpResponse;


/**
 *
 * @author Alison Fernandez
 */
public class Server {
    
    public static final String SERVER_NAME = "Apachurrito";
    private String DEFAULT_RAIZ = "root";
    
    public HttpResponse getRespuesta(HttpRequest request){
        HttpResponse response;
        HttpRequestValidator validador = new HttpRequestValidator(DEFAULT_RAIZ);
        int estadoPeticion = validador.getStatus(request);
        if(estadoPeticion == 200)
            response = new HttpResponse(estadoPeticion, DEFAULT_RAIZ + request.getResource(), request.getMethod(), request.getVersion());
        else
            response = new HttpResponse(estadoPeticion, request.getMethod(), request.getVersion());        
        return response;
    }
    
}
