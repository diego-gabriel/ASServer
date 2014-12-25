package http;

import java.util.Hashtable;
import java.util.Iterator;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Adolfo
 */
public class Statusline {

    //"HTTP/" 1*DIGIT "." 1*DIGIT SP 3DIGIT SP
    private final String HTTPVERSION = "HTTP/1.0";
    private final Hashtable<Integer, String> statusCode;
    private String reasonPhrase;

    public Statusline() {
        statusCode = new Hashtable<>();
        statusCode.put(200, "OK");
        statusCode.put(201, "Created");
        statusCode.put(202, "Accepted");
        statusCode.put(204, "No Content");
        statusCode.put(301, "Moved Permanently");
        statusCode.put(302, "Moved Temporarily");
        statusCode.put(304, "Not Modified");
        statusCode.put(400, "Bad Request");
        statusCode.put(401, "Unauthorized");
        statusCode.put(403, "Forbidden");
        statusCode.put(404, "Not Found");
        statusCode.put(500, "Internal Server Error");
        statusCode.put(501, "Not Implemented");
        statusCode.put(502, "Bad Gateway");
        statusCode.put(503, "Service Unavailable");
        //| extension-code // ??
        reasonPhrase = "";
    }

    public String getStatusLine(int code) {
        Iterator<Integer> keySetIterator = statusCode.keySet().iterator();

        while (keySetIterator.hasNext()) {
            Integer key = keySetIterator.next();
            if (key == code) {
                reasonPhrase = code + " " + statusCode.get(key);
            }
        }
        return reasonPhrase;
    }

    public Hashtable<Integer, String> getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

}
