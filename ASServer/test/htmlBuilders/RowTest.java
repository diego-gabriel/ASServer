/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlBuilders;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deigo-gabriel
 */
public class RowTest {
    

    @Test
    public void testConstruction1(){
        Row aRow = new Row();
        assertEquals("<tr>\n</tr>\n", aRow.toString());
    }
    @Test
    public void testConstruction2_full(){
        String[] data = {"a", "b", "c"};
        Row aRow = new Row(data);
        String expected =   "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n";
        
        assertEquals(expected, aRow.toString());
    }
    @Test
    public void testConstruction2_empty(){
        String[] data = {};
        Row aRow = new Row(data);
        String expected =   "<tr>\n" +
                            "</tr>\n";
        
        assertEquals(expected, aRow.toString());
    }
    @Test
    public void testadddata_full(){
        String[] data = {"a", "b"};
        Row aRow = new Row(data);
        aRow.addData("c");
        String expected =   "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n";
        
        assertEquals(expected, aRow.toString());
    }
    @Test
    public void testaddData_empty(){
        String[] data = {};
        Row aRow = new Row(data);
        aRow.addData("a");
        String expected =   "<tr>\n" +
                            "<td>a</td>\n"+
                            "</tr>\n";
        
        assertEquals(expected, aRow.toString());
    }
    
}
