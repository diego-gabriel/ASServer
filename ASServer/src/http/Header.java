package http;


import resourceManager.ResourceManager;
import java.util.Date;



/**
 *
 * @author Alison Fernandez
 */
public class Header {
    
    private int estado;
    private String fecha;
    private String servidor;
    private String conexion;
    private String tipoContenido;

    public Header(int estadoPeticion, String recurso){
        estado = estadoPeticion;
        servidor = "Apachurrito Alita";
        conexion = "Cerrada";
        setFecha();
        setTipo(recurso);
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
    
    public boolean equals(Header otro){
        return estado == (otro.estado) && 
               fecha.equals(otro.fecha) && 
               tipoContenido.equals(otro.tipoContenido);
    }
    
}
