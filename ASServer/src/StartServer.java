
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverSocket.ServerSocket;
import webServer.Server;

/**
 *
 * @author Diego Gabriel
 */
public class StartServer {
    public static void main(String args[]){
        System.out.println("Starting server...");
        try {
            new ServerSocket(80, new Server());
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Bye!");
    }
}
