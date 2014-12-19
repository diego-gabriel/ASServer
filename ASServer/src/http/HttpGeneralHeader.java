
package http;

public class HttpGeneralHeader {
    private final String date;
    
    public HttpGeneralHeader(){
        MiDateFormat now = new MiDateFormat();
        date = now.getDateFormat();
    }
    
    @Override
    public String toString(){
        return "Date: " + date;
    }
    
    
    public boolean equals(HttpGeneralHeader other){
        return date.equals(other.date);
    }
}
