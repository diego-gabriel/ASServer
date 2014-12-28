package webServer;

import http.HttpRequest;
import http.HttpResponse;
import java.net.*;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import serverSocket.ServerSocketDataReader;

public class ServerConexion {

    private final int serverPort = 2000;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream outPut;
    private String recivedMessage;
    private String[] arrayRequest;
    private Server server;
   
    public ServerConexion(Server server){
        this.server = server;
    }
    
    //inicio de servicio

    public void initServer() {
        BufferedReader entrada;
        boolean activo = true;
        try {
            serverSocket = new ServerSocket(serverPort);
            
            while (activo) {
                
                socket = serverSocket.accept();
                //Recepcion de mensaje
                ServerSocketDataReader reader = new ServerSocketDataReader();
                recivedMessage = reader.readDataFrom(socket);
                System.out.println(recivedMessage + "Fin");
                
                HttpResponse response =  server.getRespuesta(new HttpRequest(recivedMessage));
                
                outPut = new DataOutputStream(socket.getOutputStream());
                outPut.writeUTF(response.toString());
                outPut.close();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public boolean validarTipo(String tipo) {
        boolean respuesta = false;
        if (tipo.equalsIgnoreCase("get") || tipo.equalsIgnoreCase("head") || tipo.equalsIgnoreCase("post")) {
            respuesta = true;
        } else {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean validarUrl(String url) {
        String pattern = "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(url);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean validarVersion(String version) {
        if (version.equalsIgnoreCase("http/1.0") || version.equalsIgnoreCase("http/1.1")) {
            return true;
        }
        return false;
    }
}
