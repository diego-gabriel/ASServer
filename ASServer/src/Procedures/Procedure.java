
package Procedures;

/**
 *
 * @author deigo-gabriel
 */
public abstract class Procedure {
    private final String nameOfProcedure;
    
    public Procedure(String name){
        nameOfProcedure = name;
    }
    
    public abstract String run(String[][][] tables);
    
    public boolean is (String name){
        return nameOfProcedure.equals(name);
    }
}
