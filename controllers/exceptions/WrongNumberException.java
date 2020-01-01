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
public class WrongNumberException extends Exception {

    public WrongNumberException() {
        super("The number must be [0-99].");
    }
    
}
