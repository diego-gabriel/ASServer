
/**
 *
 * @author Alison Fernandez
 */
public class Servidor {
    
    private String DEFAULT_RAIZ = "archivos";
    
    public RespuestaHttp getRespuesta(PeticionHttp peticion){
        RespuestaHttp respuesta;
        ValidadorPeticion validador = new ValidadorPeticion(DEFAULT_RAIZ);
        int estadoPeticion = validador.getEstado(peticion);
        
        if(estadoPeticion == 200)
            respuesta = new RespuestaHttp(estadoPeticion, DEFAULT_RAIZ + peticion.getRecurso(), peticion.getMetodo());
        else
            respuesta = new RespuestaHttp(estadoPeticion, peticion.getRecurso());
        
        return respuesta;
    }
    
}
