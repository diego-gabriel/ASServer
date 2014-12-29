
package htmlBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deigo-gabriel
 */
public class Table {
    
    private List<Row> rows;
    public Table(){
        rows = new ArrayList<>();
    }
    public Table(String[][] table){
        rows = new ArrayList<>();
        for(String[] aRow : table)
            addRow(aRow);
    }
    
    public void addRow(String[] aRow){
        rows.add(new Row(aRow));
    }
    
    @Override
    public String toString(){
        String html = "<table>\n";
        
        for (Row aRow : rows)
            html = html + aRow.toString();
        
        html = html + "</table>\n";
        return html;
    }
}
