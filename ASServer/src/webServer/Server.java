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
    private final String DEFAULT_ROOT = "root";
    private ServerConexion serverConexion;
    
    public HttpResponse getRespuesta(HttpRequest request){
        HttpResponse response;
        HttpRequestValidator validador = new HttpRequestValidator(DEFAULT_ROOT);
        int estadoPeticion = validador.getStatus(request);
        if (estadoPeticion == 200) {
            response = new HttpResponse(estadoPeticion, DEFAULT_ROOT + request.getResource(), request.getMethod(), request.getVersion());
        } else {
            response = new HttpResponse(estadoPeticion, request.getMethod(), request.getVersion());
        }
        return response;
    }
    
    public void initService() {
        serverConexion = new ServerConexion(this);
        serverConexion.initServer();
    }

    public ServerConexion getServerConexion() {
        return serverConexion;
    }
}
