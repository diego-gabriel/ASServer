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
    
    public boolean existe(String resource){
        
        File file = new File(completeExtension(resource));
        return file.exists();
    }

    public String getType(String resource) {
        if(resource.contains(".html")){
            return "text/html";
        }
        if(resource.endsWith(".css")){
            return "text/css";
        }
        if(resource.endsWith(".txt")){
            return "text/plain";
        }
        if(resource.endsWith(".gif")){
            return "image/gif";
        }
        if(resource.endsWith(".png")){
            return "image/png";
        }
        return "Sin tipo";
    }

    public String getLastModification(String resource) {
        File file = new File(resource);
        long fechaMs = file.lastModified();
        Date date = new Date(fechaMs);
        return date.toString();
    }
    
    public File getResourceFor(int httpStatus){
        String pathToResource = "root/errorFile/" + httpStatus + ".html";
        return new File(pathToResource);
    }
    
    public File getResource(String resource){
        return new File(resource);
    }
    
    private String completeExtension(String path){
        String completePath = path;
        
        if (!path.endsWith(".html"))
            completePath = path + ".html";
        
        System.out.println(path + " -> " + completePath);
        
        return completePath;
    }
    
}
