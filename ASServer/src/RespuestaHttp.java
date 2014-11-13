
/**
 *
 * @author Alison Fernandez
 */
public class RespuestaHttp {
    
    private Object cabeza;
    
    public RespuestaHttp(int estado, String recurso){
        cabeza = new Cabecera(estado, recurso);
    }

    public RespuestaHttp(int estadoPeticion, String recurso, String metodo) {
        cabeza = new CabeceraOK(estadoPeticion, metodo, recurso);
    }
    
    private Object getCabeza(){
        return cabeza;
    }
    
    @Override
    public boolean equals(Object otraRespuesta){
        Object cabezaOtro = ((RespuestaHttp)otraRespuesta).getCabeza();
        return cabezaOtro.equals(cabeza);
    }
}
