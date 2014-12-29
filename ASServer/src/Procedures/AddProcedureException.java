/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Procedures;

/**
 *
 * @author deigo-gabriel
 */
public class AddProcedureException extends Exception{
    private String message;
    
    public AddProcedureException(String msg){
        message = msg;
    }
    
    @Override
    public String getMessage(){
        return message;
    }
}
