
package parsers;

/**
 *
 * @author deigo-gabriel
 */
public class PDTInputNotParseable extends Exception{
    @Override
    public void printStackTrace(){
        System.out.println("La entrada es erronea");
        super.printStackTrace();
    }
}
