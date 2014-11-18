package http;


import resourceManager.ResourceManager;


/**
 *
 * @author Alison Fernandez
 */
public class HttpRequestValidator {
    
    private String metodos[] = {"HEAD", "GET", "POST"};
    private String ruta;
    
    public HttpRequestValidator(String ruta){
        this.ruta = ruta;
    }
    
    public int getEstado(HttpRequest peticion){
        String metodo, recurso, version;
        metodo = peticion.getMetodo();
        recurso = peticion.getRecurso();
        version = peticion.getVersion();
        
        ResourceManager controlador = new ResourceManager();
        
        if(!metodoImplementado(metodo))
            return 501;
        if(recurso.isEmpty())
            return 400;
        if(!version.equals("HTTP/1.0"))
            return 400;
        if(controlador.existe(ruta + recurso))
            return 200;
        else
            return 404;
    }

    private boolean metodoImplementado(String metodo) {
        int metodoDefinido = 0;
        while(metodoDefinido < metodos.length){
            if(metodos[metodoDefinido].equals(metodo))
                return true;
            metodoDefinido++;
        }
        return false;
    }
    
}
