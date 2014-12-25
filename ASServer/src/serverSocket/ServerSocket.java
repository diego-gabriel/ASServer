/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverSocket;

import http.HttpRequest;
import http.HttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;  
import webServer.Server;

/**
 *
 * @author Diego Gabriel
 */
public class ServerSocket {
    
    private java.net.ServerSocket socket;
    private Server server;
    public ServerSocket(int port, Server serv) throws IOException{
        socket = new java.net.ServerSocket(port);
        server = serv;
        startListening();
    }
    
    private void startListening() throws IOException{
        String inputRequest = "";
        HttpResponse response;
        try (Socket connection = socket.accept()) {
            PrintWriter output = new PrintWriter(connection.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            boolean fst = true;
            String line = "";
            int contentLength = 0;
            while ((line = input.readLine()) != null) {
                if (!fst)
                    inputRequest = inputRequest + "\n";
                else
                    fst = false;
                
                inputRequest = inputRequest + line;
                
                if(line.startsWith("Content-Length: "))
                    contentLength = Integer.parseInt(line.substring("Content-Length: ".length()));
                
                if (line.length() == 0)
                    break;
            }
            if (contentLength > 0)
                inputRequest = inputRequest + "\n";
            inputRequest = inputRequest + readBody(contentLength, input); 
            
            
            HttpRequest request = new HttpRequest(inputRequest);
            System.out.println(inputRequest);
            response = server.getRespuesta(request);
            output.print(response.toString());
            output.close();
            input.close();
            connection.close();
        }
        System.out.println(inputRequest);
        
    }
    
    private String readBody(int n, BufferedReader in) throws IOException{
        String res = "";
        for (int i = 0; i < n; i++){
            res = res + ((char)in.read());
        }
            
        return res;
    }
    
}
