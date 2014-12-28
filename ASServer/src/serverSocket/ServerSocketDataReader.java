package serverSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Diego Gabriel
 */
public class ServerSocketDataReader {


    public ServerSocketDataReader() {
    }

    public String readDataFrom(Socket connection) throws IOException {

        String inputRequest = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        boolean fst = true;
        String line = "";
        int contentLength = 0;
        while ((line = input.readLine()) != null) {
            if (!fst) {
                inputRequest = inputRequest + "\n";
            } else {
                fst = false;
            }

            inputRequest = inputRequest + line;

            if (line.startsWith("Content-Length: ")) {
                contentLength = Integer.parseInt(line.substring("Content-Length: ".length()));
            }

            if (line.length() == 0) {
                break;
            }
        }
        if (contentLength > 0) {
            inputRequest = inputRequest + "\n";
        }
        inputRequest = inputRequest + readBody(contentLength, input);

        return inputRequest;
    }

    

    private String readBody(int n, BufferedReader in) throws IOException {
        String res = "";
        for (int i = 0; i < n; i++) {
            res = res + ((char) in.read());
        }

        return res;
    }

}
