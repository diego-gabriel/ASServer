package resourceManager;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ResourceManager {
    
    public boolean existe(String resource){
        
        File file = new File(resource);
        return file.exists();
    }

    public String getType(String resource) {
        File file = new File(resource);
        String type = "application/octet-stream";
        
        try{
          type = Files.probeContentType(file.toPath());
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return type;
    }

    public String getLastModification(String resource) {
        File file = new File(resource);
        long fechaMs = file.lastModified();
        Date date = new Date(fechaMs);
        return date.toString();
    }
    
    public long getLength(String resource){
        File file = new File (resource);
        long length = 0;
        if (file.exists()){
            length = file.length();
        }
        return length;
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
        
        return completePath;
    }
    
}
