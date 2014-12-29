
package htmlBuilders;

public class TablaSuma {
    String[][] table;
    
    public TablaSuma(String[][] table){
        this.table = table;
    }
    
    @Override
    public String toString(){
        String html = "<table><tbody><tr>";
        int suma = 0;
        for (int filas = 0; filas < table.length; filas++) {
            suma = 0;
            for (int col = 0; col < table[filas].length; col++) {
                suma = suma + Integer.parseInt(table[filas][col]);
            }
            html = html +"<td>"+suma+"</td>";
            System.out.println("");
        }
        html = html + "</tr></tbody></table>";
        return html;
    }
}
