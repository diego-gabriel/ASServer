
/**
 *
 * @author Alison Fernandez
 */
public class PeticionHttp {
    
    private String metodo;
    private String recurso;
    private String version;
    private String DEFAULT_VALUE = "/index.html";
    
    public PeticionHttp(String metodo, String recurso, String version){
        this.metodo = metodo;
        if(recurso.equals("/")){
            recurso = DEFAULT_VALUE;
        }
        this.recurso = recurso;
        this.version = version;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getVersion() {
        return version;
    }
}
