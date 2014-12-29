
package Procedures;

import htmlBuilders.Table;
import java.math.BigInteger;

/**
 *
 * @author deigo-gabriel
 */
public class Add extends Procedure{

    public Add(){
        super("/add");
    }
    
    @Override
    public String run(String[][][] tables) {
        String html = "<html>\n";
        
        try{
            checkValid(tables);
            String sum[][] = new String[tables[0].length][tables[0][0].length];
            fill(sum);
            for (String[][] aTable : tables){
                sum = add(sum, aTable);
            }
            
            Table sumTable = new Table(sum);
            html = html + sumTable.toString();
        } catch (AddProcedureException e){
            html = html + "<b> Somethig bad happened:" +
                    "<br>\n <i>" + e.getMessage() + "</i>\n";
        }
        return html + "</html>";
    }
    
    private void checkValid(String[][][] tables) throws AddProcedureException{
        boolean valid = tables.length > 0 && tables[0].length > 0;
        if (valid){
            int xlengthpattern = tables[0].length;
            int ylengthpattern = tables[0][0].length;
            System.out.println("x:" + xlengthpattern);
            System.out.println("y:" + ylengthpattern);
            
            
            try{
                for (String[][] aTable : tables){
                    valid = valid && isValidTable(aTable, xlengthpattern, ylengthpattern);
                }
            } catch (AddProcedureException e){
                throw e;
            }
        }
            
        if (!valid)
            throw new AddProcedureException("No se pueden sumar las matrices");

    }
    
    private boolean isValidTable(String[][] aTable, int xLength, int yLength) throws AddProcedureException{
        boolean isValid = aTable.length == xLength;
        
        if (isValid)
            for (String[] aRow : aTable){
                isValid = isValid && aRow.length == yLength;
                if (!allDataAreNumbers(aRow))
                    throw new AddProcedureException("Uno o mas de los datos no son numeros. Imposible sumar");
            }
        
        return isValid;
    }
    
    private boolean allDataAreNumbers(String[] aRow){
        
        boolean ok = true;
        try{
            for (String data: aRow){
                Integer.parseInt(data);
            }
        } catch (NumberFormatException e){
            ok = false;
        }
        
        return ok;
    }
    
    private String[][] add(String[][] a, String[][] b){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++){
                BigInteger sum1 = new BigInteger(a[i][j]);
                BigInteger sum2 = new BigInteger(b[i][j]);
                BigInteger result = sum1.add(sum2);
                a[i][j] = result.toString();
            }
        }

        return a;
    }
    
    private void fill(String[][] s){
        for (int i = 0; i < s.length; i++)
            for (int j = 0; j < s[0].length; j++){
                s[i][j] = "0";
            }
    }
}

 
