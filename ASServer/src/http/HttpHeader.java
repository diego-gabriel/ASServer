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
    
    @Override
    public boolean equals(Object otro){
        boolean respuesta = false;
        if(otro instanceof HttpHeader)
        {
            HttpHeader otherHeader = (HttpHeader)otro;

            respuesta =  estado == (otherHeader.estado) && 
               fecha.equals(otherHeader.fecha) && 
               tipoContenido.equals(otherHeader.tipoContenido);
        }
        
        return respuesta;
    }
    
}
