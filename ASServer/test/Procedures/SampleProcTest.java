package Procedures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deigo-gabriel
 */
public class SampleProcTest {
    
    @Test
    public void testRun(){
        SampleProc proc = new SampleProc();
        String[][][] tables = new String[0][0][0];
        assertEquals("This is a Sample Procedure {nOfTables: 0}", proc.run(tables));
    }
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
