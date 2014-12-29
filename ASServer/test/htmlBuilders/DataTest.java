
package htmlBuilders;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deigo-gabriel
 */
public class DataTest {
    @Test
    public void testData1(){
        Data data = new Data("un dato");
        assertEquals("<td>un dato</td>\n", data.toString());
    }
    @Test
    public void testData2(){
        Data data = new Data("");
        assertEquals("<td></td>\n", data.toString());
    }
}
