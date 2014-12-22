package webServer;

import java.net.*;

import java.io.*;

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
                
                validarMensaje(arrayRequest);
                
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
    
    public void validarMensaje(String[] mensaje){
        
    }
    
}
