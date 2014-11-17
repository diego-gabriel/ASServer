

/**
 *
 * @author Alison Fernandez
 */
public class CabeceraOK{
    
    private Header cabezaDefecto;
    private String metodo;
    private String ultimaModificacion;

    public CabeceraOK(int estadoPeticion, String metodo, String recurso) {
        cabezaDefecto = new Header(estadoPeticion, recurso);
        this.metodo = metodo;
        setultimaModificacion(recurso);
    }
    
    public String getMetodo(){
        return metodo;
    }
    
    public String getUltimaModif(){
        return ultimaModificacion;
    }
    
    public Header getPorDefecto(){
        return cabezaDefecto;
    }
    

    private void setultimaModificacion(String recurso) {
        ManejadorArchivo manejador = new ManejadorArchivo();
        ultimaModificacion = manejador.getultimaModificacion(recurso);
    }
    
    @Override
    public boolean equals(Object otro){
        return cabezaDefecto.equals(((CabeceraOK)otro).getPorDefecto()) && 
            metodo.equals(((CabeceraOK)otro).getMetodo()) &&
            ultimaModificacion.equals(((CabeceraOK)otro).getUltimaModif());
    }
    
}
