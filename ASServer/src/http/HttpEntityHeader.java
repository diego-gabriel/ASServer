/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http;

import resourceManager.ResourceManager;

/**
 *
 * @author Diego Gabriel
 */
public class HttpEntityHeader {
    
    private final String contentType;
    private final String lastModified;
    
    public HttpEntityHeader(String resource){
        ResourceManager manager = new ResourceManager();
        contentType = manager.getType(resource);
        lastModified = manager.getLastModification(resource);
    }
    
    public boolean equals(HttpEntityHeader other){
        return contentType.equals(other.contentType)
               && lastModified.equals(other.lastModified);
    }
}
