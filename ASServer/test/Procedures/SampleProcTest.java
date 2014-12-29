package Procedures;

import htmlBuilders.Table;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deigo-gabriel
 */
public class SampleProcTest {
    
    
    @Test
    public void test_is(){
        SampleProc proc = new SampleProc();
        assertTrue(proc.is("/sampleProc"));
    }
    @Test
    public void test_isnt(){
        SampleProc proc = new SampleProc();
        assertFalse(proc.is("/sampleProc2"));
    }
    
}
