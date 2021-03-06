package http;


import resourceManager.ProcedureManager;
import resourceManager.ResourceManager;


/**
 *
 * @author Alison Fernandez
 */
public class HttpRequestValidator {
    
    private final String methods[] = {"HEAD", "GET", "POST"};
    private final String path;
    
    public HttpRequestValidator(String path){
        this.path = path;
    }
    
    public int getStatus(HttpRequest peticion){
        String method, resource, version;
        method = peticion.getMethod();
        resource = peticion.getResource();
        version = peticion.getVersion();
        
        ResourceManager manager = new ResourceManager();
        ProcedureManager procManager = new ProcedureManager();
        if(!implementedMethod(method))
            return 501;
        if(resource.isEmpty())
            return 400;
        if(!version.equals("HTTP/1.1"))
            return 505;
        if(manager.existe(path + resource) || procManager.isValidProcedure(resource))
            return 200;
        else
            return 404;
    }

    private boolean implementedMethod(String metodo) {
        int metodoDefinido = 0;
        while(metodoDefinido < methods.length){
            if(methods[metodoDefinido].equals(metodo))
                return true;
            metodoDefinido++;
        }
        return false;
    }
    
}
