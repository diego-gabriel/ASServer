package resourceManager;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ResourceManager {
    
    public boolean existe(String recurso){
        try {
            FileInputStream archivo = new FileInputStream(recurso);
            return  true;
        } catch (FileNotFoundException ex) {
            return  false;
        }
    }

    public String getTipo(String recurso) {
        if(recurso.contains(".html")){
            return "text/html";
        }
        if(recurso.endsWith(".css")){
            return "text/css";
        }
        if(recurso.endsWith(".txt")){
            return "text/plain";
        }
        if(recurso.endsWith(".gif")){
            return "image/gif";
        }
        if(recurso.endsWith(".png")){
            return "image/png";
        }
        return "Sin tipo";
    }

    public String getultimaModificacion(String recurso) {
        File archivo = new File(recurso);
        long fechaMs = archivo.lastModified();
        Date fecha = new Date(fechaMs);
        return fecha.toString();
    }
}
