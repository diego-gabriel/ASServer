package webServer;

import java.net.*;

import java.io.*;

public class ServerConexion {

    private final int serverPort = 5000;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream outPut;
    private String recivedMessage;

    //inicio de servicio
    public void initServer() {
        BufferedReader entrada;

        try {
            serverSocket = new ServerSocket(serverPort);
            socket = new Socket();
            System.out.println("esperando una conexión:");
            socket = serverSocket.accept();
            System.out.println("un cliente se ha conectado!");

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outPut = new DataOutputStream(socket.getOutputStream());
            System.out.println("confirmando conexion al cliente....");
            outPut.writeUTF("conexión exitosa... envia un mensaje ");
            //Recepcion de mensaje
            recivedMessage = entrada.readLine();
            System.out.println(recivedMessage);
            outPut.writeUTF("se recibio mensaje. Terminando conexion...");
            outPut.writeUTF("gracias por conectarte, adios!");
            System.out.println("cerrando conexión...");
            serverSocket.close();//Aqui se cierra la conexión con el cliente
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
