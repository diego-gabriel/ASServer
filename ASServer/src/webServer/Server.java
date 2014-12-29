package webServer;

import http.HttpRequest;
import http.HttpRequestValidator;
import http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.PDTInputNotParseable;
import parsers.PDTParser;
import resourceManager.ProcedureManager;

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
            ProcedureManager procManager = new ProcedureManager();
            if (procManager.isValidProcedure(request.getResource())){
                if (request.getMethod().equals("POST")){
                    PDTParser parser = new PDTParser();
                    try {
                        String[][][] tables = parser.parse(request.getParams());
                        procManager.execProc(tables, request.getResource());
                        response = new HttpResponse(estadoPeticion, "apps" + request.getResource(), request.getMethod(), request.getVersion());
                    } catch (PDTInputNotParseable ex) {
                        response = new HttpResponse(400, request.getMethod(), request.getVersion());
                    }
                }
                else{
                    procManager.generateFormFor(request.getResource());
                    
                    response = new HttpResponse(estadoPeticion, "apps" + request.getResource(), request.getMethod(), request.getVersion());
                }
            }
            else
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
