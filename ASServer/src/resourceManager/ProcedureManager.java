
package resourceManager;
import Procedures.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author deigo-gabriel
 */
public class ProcedureManager {
    public final Procedure[] procedures = {new SampleProc(), new SumarProc()};
    
    public boolean isValidProcedure(String thatProc){
        return findProc(thatProc) != null;
    }
    
    private Procedure findProc(String thatProc){
        
        int procID = 0;
        while (procID < procedures.length && !procedures[procID].is(thatProc)){
            procID++;
        }
        return procID < procedures.length ? procedures[procID] : null;
    }
    
    public void execProc(String[][][] tables, String aProcName){
        
        Procedure aProc = findProc(aProcName);
        try {
            File file = new File("apps" + aProcName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(aProc.run(tables));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ProcedureManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
