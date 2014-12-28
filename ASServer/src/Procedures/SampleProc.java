
package Procedures;

/**
 *
 * @author deigo-gabriel
 */
public class SampleProc extends Procedure{
    
    public SampleProc(){
        super("/sampleProc");
    }

    @Override
    public String run(String[][][] tables) {
        return "This is a Sample Procedure {nOfTables: "+ tables.length + "}";
    }
    
}
