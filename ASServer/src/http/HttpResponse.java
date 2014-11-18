package http;


/**
 *
 * @author Alison Fernandez
 */
public class HttpResponse {
    
    private Object cabeza;
    
    public HttpResponse(int estado, String recurso){
        cabeza = new Header(estado, recurso);
    }

    public HttpResponse(int estadoPeticion, String recurso, String metodo) {
        cabeza = new CabeceraOK(estadoPeticion, metodo, recurso);
    }
    
    private Object getCabeza(){
        return cabeza;
    }
    
    @Override
    public boolean equals(Object otraRespuesta){
        Object cabezaOtro = ((HttpResponse)otraRespuesta).getCabeza();
        return cabezaOtro.equals(cabeza);
    }
}
