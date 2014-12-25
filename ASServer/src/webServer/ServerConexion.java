package webServer;

import java.net.*;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerConexion {

    private final int serverPort = 5000;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream outPut;
    private String recivedMessage;
    String[] arrayRequest;
    //inicio de servicio
    public void initServer() {
        BufferedReader entrada;
        boolean activo = true;
        try {
            serverSocket = new ServerSocket(serverPort);
            socket = new Socket();
            System.out.println("esperando una conexcion:");
            
                socket = serverSocket.accept();
                System.out.println("un cliente se ha conectado!");

                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outPut = new DataOutputStream(socket.getOutputStream());
                System.out.println("confirmando conexion al cliente....");
            while (activo) {
                outPut.writeUTF("request:");
                //Recepcion de mensaje
                recivedMessage = entrada.readLine();
                arrayRequest =  (recivedMessage.trim()).split("\\s+");
                
                if(validarTipo(arrayRequest[0])&&validarUrl(arrayRequest[1])&&validarVersion(arrayRequest[2])){
                    System.out.println("proceder con cabecera");
                }else{
                    System.out.println("BAD REQUEST!");
                }
                System.out.println(recivedMessage);
                outPut.writeUTF("procesing...");
            //outPut.writeUTF("gracias por conectarte, adios!");
                //System.out.println("cerrando conexión...");
                //if (recivedMessage.equalsIgnoreCase("exit")) {
                    //outPut.writeUTF("byby");
                    //serverSocket.close();
                    //activo = false;
                //}
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
    
    public boolean validarTipo(String tipo){
        boolean respuesta = false;
        if(tipo.equalsIgnoreCase("get") || tipo.equalsIgnoreCase("head") || tipo.equalsIgnoreCase("post")){
            respuesta = true;
        }else{
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
        if(version.equalsIgnoreCase("http/1.0") || version.equalsIgnoreCase("http/1.1")){
            return true;
        }
        return false;
    }
    
    
    
}
