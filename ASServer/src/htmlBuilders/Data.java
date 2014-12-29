
package htmlBuilders;

/**
 *
 * @author deigo-gabriel
 */
public class Data {
    private String data;
    
    public Data(String data){
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "<td>" + data + "</td>\n";
    }
}
