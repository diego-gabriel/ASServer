import http.Statusline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Adolfo
 */
public class StatuslineTest {
    
    @Test
    public void testStatusLine() {
        Statusline statusline = new Statusline();
        
        assertNotNull(statusline.getStatusCode());
    }
    
    @Test
    public void testGetStatusLine200() {
        Statusline statusline = new Statusline();
        String generado = statusline.getStatusLine(200);
        String esperado = "200 OK";
        assertEquals(esperado, generado);
    }
    @Test
    public void testGetStatusLine500() {
        Statusline statusline = new Statusline();
        String generado = statusline.getStatusLine(500);
        String esperado = "500 Internal Server Error";
        assertEquals(esperado, generado);
    }
}
