
package Procedures;

import htmlBuilders.TablaSuma;


public class SumarProc extends Procedure{
    
    public SumarProc(){
        super("/sumaFilas");
    }

    @Override
    public String run(String[][][] tables) {
        String sumarFilas = "<html>Table Suma "+ tables.length + "}";
        
        for (String[][] aTable : tables)
            sumarFilas = sumarFilas + (new TablaSuma(aTable));
        
        return sumarFilas + "</html>";
        
    }
    
}
