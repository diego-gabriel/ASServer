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
public class TableTest {
    
    @Test
    public void testConstruction1(){
        Table aTable = new Table();
        assertEquals("<table>\n</table>\n", aTable.toString());
    }
    @Test
    public void testConstruction2_empty(){
        String[][] table = {};
        Table aTable = new Table(table);
        assertEquals("<table>\n</table>\n", aTable.toString());
    }
    @Test
    public void testConstruction2_full(){
        String[][] table = {{"a", "b", "c"},
                            {"a", "b", "c"}};
        Table aTable = new Table(table);
        String expected =   "<table>\n" +
                            "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n" +
                            "</table>\n";
        assertEquals(expected, aTable.toString());
    }
    @Test
    public void testaddRow_full(){
        String[][] table = {{"a", "b", "c"}};
        String[] aRow = {"a", "b", "c"};
        Table aTable = new Table(table);
        aTable.addRow(aRow);
        String expected =   "<table>\n" +
                            "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n" +
                            "</table>\n";
        assertEquals(expected, aTable.toString());
    }
    @Test
    public void testaddRow_empty(){
        String[][] table = {};
        String[] aRow = {"a", "b", "c"};
        Table aTable = new Table(table);
        aTable.addRow(aRow);
        String expected =   "<table>\n" +
                            "<tr>\n" +
                            "<td>a</td>\n" +
                            "<td>b</td>\n" +
                            "<td>c</td>\n" +
                            "</tr>\n" +
                            "</table>\n";
        assertEquals(expected, aTable.toString());
    }
    
}
