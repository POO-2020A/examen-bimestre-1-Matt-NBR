/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen1;

/**
 *
 * @author MATEO
 */
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(scanner);
        ui.start();

    }
    
}
