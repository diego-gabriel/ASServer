
package Procedures;

import htmlBuilders.Table;

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
        String response = "<html>This is a Sample Procedure {nOfTables: "+ tables.length + "}";
        
        for (String[][] aTable : tables)
            response = response + (new Table(aTable));
        
        return response + "</html>";
        
    }
    
}
