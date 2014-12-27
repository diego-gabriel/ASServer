import http.MiDateFormat;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Adolfo
 */
public class MiDateFormatTest {
    @Test
    public void testGetDateFormat() {        
        MiDateFormat miDateFormat = new MiDateFormat();
        String fechaGenerada = miDateFormat.getDateFormat();
        String fechaEsperada = "Thu, 04 Dec 2014 0:27: GMT";        
        assertEquals(fechaEsperada,fechaGenerada);
    }
    
}
