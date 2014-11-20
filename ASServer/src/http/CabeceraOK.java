package http;


import resourceManager.ResourceManager;

public class CabeceraOK{
    
    private HttpHeader cabezaDefecto;
    private String metodo;
    private String ultimaModificacion;

    public CabeceraOK(int estadoPeticion, String metodo, String recurso) {
        cabezaDefecto = new HttpHeader(estadoPeticion, recurso);
        this.metodo = metodo;
        setultimaModificacion(recurso);
    }
   
    private void setultimaModificacion(String recurso) {
        ResourceManager manejador = new ResourceManager();
        ultimaModificacion = manejador.getultimaModificacion(recurso);
    }
    
    @Override
    public boolean equals(Object other){
        CabeceraOK otro;
        boolean answer = false;
        if (other instanceof CabeceraOK){
            otro = (CabeceraOK) other;
            answer =   cabezaDefecto.equals(otro.cabezaDefecto) && 
                    metodo.equals(otro.metodo) &&
                    ultimaModificacion.equals(otro.ultimaModificacion);
        }
        return answer;
    }
    
}
