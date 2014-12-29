
package htmlBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deigo-gabriel
 */
public class Row {
    private List<Data> data;
    
    public Row(){
        data = new ArrayList<>();
    }
    public Row(String[] aRowData){
        data = new ArrayList<>();
        for (String aData : aRowData)
            addData(aData);
    }
    
    public void addData(String aData){
        data.add(new Data(aData));
    }
    
    @Override
    public String toString(){
        String html = "<tr>\n";
        
        for (Data aData : data)
            html = html + aData.toString();
        
        html = html + "</tr>\n";
        
        return html;
    }
    
}
