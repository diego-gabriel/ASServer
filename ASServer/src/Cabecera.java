
import java.util.Date;



/**
 *
 * @author Alison Fernandez
 */
public class Cabecera {
    
    private int estado;
    private String fecha;
    private String servidor;
    private String conexion;
    private String tipoContenido;

    public Cabecera(int estadoPeticion, String recurso){
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
        ManejadorArchivo manejador = new ManejadorArchivo();
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
        return this.estado == ((Cabecera)otro).getEstado() && 
               this.fecha.equals(((Cabecera)otro).getFecha()) && 
               this.tipoContenido.equals(((Cabecera)otro).getTipoContenido());
    }
    
}
