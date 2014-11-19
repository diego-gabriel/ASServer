package http;


import resourceManager.ResourceManager;
import java.util.Date;



/**
 *
 * @author Alison Fernandez
 */
public class HttpHeader {
    
    private int estado; 
    private String fecha; 
    private final String servidor;
    private String tipoContenido;

    public HttpHeader(int estadoPeticion, String recurso){
        estado = estadoPeticion;
        servidor = "Apachurrito";
        setFecha();
        setTipo(recurso);
    }
    
    public HttpHeader(int status){
        //implementar
        servidor = null;
        fecha = null;
        tipoContenido = null;
    }
    
    private void setFecha(){
        Date d = new Date();
        fecha = d.toString();  
    }
    
    private void setTipo(String recurso){
        ResourceManager manejador = new ResourceManager();
        tipoContenido = manejador.getTipo(recurso);
    }
    
    public int getEstado(){
        return estado;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public String getTipoContenido(){
        return tipoContenido;
    }
    
    public boolean equals(HttpHeader otro){
        
        System.out.println(estado + " -> " + otro.estado);
        System.out.println(fecha + " -> " + otro.fecha);
        System.out.println(tipoContenido + " -> " + otro.tipoContenido);

        return estado == (otro.estado) && 
               fecha.equals(otro.fecha) && 
               tipoContenido.equals(otro.tipoContenido);
    }
    
}
