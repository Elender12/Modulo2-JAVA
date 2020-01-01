/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.futurepath.controllers.exceptions;

/**
 *
 * @author anselm
 */
public class WrongNameException extends Exception {

    public WrongNameException() {
        super("Player name must not be empty.");
    }
    
}
