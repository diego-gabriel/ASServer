package http;


import resourceManager.ResourceManager;



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
        ResourceManager manejador = new ResourceManager();
        ultimaModificacion = manejador.getultimaModificacion(recurso);
    }
    
    public boolean equals(CabeceraOK otro){
        return cabezaDefecto.equals(otro.cabezaDefecto) && 
            metodo.equals(otro.metodo) &&
            ultimaModificacion.equals(otro.ultimaModificacion);
    }
    
}
