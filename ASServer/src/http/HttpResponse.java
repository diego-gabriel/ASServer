package http;


/**
 *
 * @author Alison Fernandez
 */
public class HttpResponse {
    
    private Object cabeza;
    
    public HttpResponse(int estado, String recurso){
        cabeza = new HttpHeader(estado, recurso);
    }

    public HttpResponse(int estadoPeticion, String recurso, String metodo) {
        cabeza = new CabeceraOK(estadoPeticion, metodo, recurso);
    }
    
    @Override
    public boolean equals(Object otraRespuesta){
        boolean respuesta = false;
        if(otraRespuesta instanceof HttpResponse)
        {
            Object cabezaOtro = ((HttpResponse)otraRespuesta).cabeza;
            respuesta = cabezaOtro.equals(cabeza);
        }
        
        return respuesta;
    }
}
