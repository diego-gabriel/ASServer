/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http;

import webServer.Server;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponseHeader {
    private final String server;
    
    public HttpResponseHeader(){
        server = Server.SERVER_NAME;
    }
    
    public boolean equals(HttpResponseHeader other){
        return server.equals(other.server);
    }
}
