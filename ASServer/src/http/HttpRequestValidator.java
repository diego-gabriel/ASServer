package http;


import resourceManager.ResourceManager;


/**
 *
 * @author Alison Fernandez
 */
public class HttpRequestValidator {
    
    private String methods[] = {"HEAD", "GET", "POST"};
    private String path;
    
    public HttpRequestValidator(String path){
        this.path = path;
    }
    
    public int getStatus(HttpRequest peticion){
        String method, resource, version;
        method = peticion.getMethod();
        resource = peticion.getResource();
        version = peticion.getVersion();
        
        ResourceManager manager = new ResourceManager();
        
        if(!implementedMethod(method))
            return 501;
        if(resource.isEmpty())
            return 400;
        if(!version.equals("HTTP/1.0"))
            return 505;
        if(manager.existe(path + resource))
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
