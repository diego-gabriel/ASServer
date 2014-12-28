
package resourceManager;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deigo-gabriel
 */
public class ProcedureManagerTest {
    
    @Test
    public void test_isValidProcedure(){
        ProcedureManager procManager = new ProcedureManager();
        assertTrue(procManager.isValidProcedure("/sampleProc"));
    }
    
    @Test
    public void test_isValidProcedureFail(){
        
        ProcedureManager procManager = new ProcedureManager();
        assertFalse(procManager.isValidProcedure("/sampleproc"));
    }
    
    @Test
    public void test_exec(){
        ProcedureManager procManager = new ProcedureManager();
        String[][][] tables = new String[0][0][0];
        procManager.execProc(tables, "/sampleProc");
        File f = new File ("apps/sampleProc");
        assertTrue(f.exists());
    }
}
