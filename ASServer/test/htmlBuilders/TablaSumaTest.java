package htmlBuilders;

import org.junit.Test;
import static org.junit.Assert.*;



public class TablaSumaTest {
    
    @Test
    public void  testToString() {
        
        String tablaString[][] = { {"1","2"},{"3","4"},{"5","6"} };
        
        String esperado = "<table><tbody><tr><td>3</td><td>7</td><td>11</td></tr></tbody></table>";
        TablaSuma tablaSuma = new TablaSuma(tablaString);
        System.out.println("tabla:"+tablaSuma.toString());
        assertEquals(esperado, tablaSuma.toString());

    }
    
    @Test
    public void  testToString3x4() {
        
        String tablaString[][] = { {"1","1","1","1"},{"2","2","2","2"},{"3","3","3","3"} };
        
        String esperado = "<table><tbody><tr><td>4</td><td>8</td><td>12</td></tr></tbody></table>";
        TablaSuma tablaSuma = new TablaSuma(tablaString);
        System.out.println("tabla:"+tablaSuma.toString());
        assertEquals(esperado, tablaSuma.toString());

    }
    
}
