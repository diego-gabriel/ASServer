
/**
 *
 * @author Alison Fernandez
 */
public class ValidadorPeticion {
    
    private String metodos[] = {"HEAD", "GET", "POST"};
    private String ruta;
    
    public ValidadorPeticion(String ruta){
        this.ruta = ruta;
    }
    
    public int getEstado(PeticionHttp peticion){
        String metodo, recurso, version;
        metodo = peticion.getMetodo();
        recurso = peticion.getRecurso();
        version = peticion.getVersion();
        
        ManejadorArchivo controlador = new ManejadorArchivo();
        
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
