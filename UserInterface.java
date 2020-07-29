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


public class UserInterface {
    private Scanner scanner;
    private Plane plane;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public boolean validPlaneSize(int rows, int cols) {
        if ((rows <= 20) && (cols <= 8)) {
            return true;
        }
        return false;
    }
    
    public Seat findSeat(int row, String col) {
        Seat testSeat = new Seat(row, col);
        for (Seat seat : this.plane.getSeats()) {
            if (seat.equals(testSeat)) {
                testSeat = seat;
            }
        }
        return testSeat;
    }
    
    public Passenger findPassenger(String name, String lastName) {
        Passenger testPassenger = new Passenger(name, lastName);
        for (Seat seat : this.plane.getSeats()) {
            if (seat.getPassenger().equals(testPassenger)) {
                testPassenger = seat.getPassenger();
            }
        }
        return testPassenger;
    }
    
    public void start() {
        while (true) {
            System.out.println("Ingrese la cantidad de filas:");
            int rows = Integer.valueOf(this.scanner.nextLine());
            System.out.println("Ingrese la cantidad de columnas:");
            int cols = Integer.valueOf(this.scanner.nextLine());
            if (this.validPlaneSize(rows, cols) == false) {
                System.out.println("Columnas o filas ingresadas exceden el maximo"
                        + " permitido!");
                System.out.println("");
            } else {
                this.plane = new Plane(rows, cols);
                this.plane.addSeats();
                break;
            }
        }
        
        while (true) {
            System.out.println(this.plane);
            System.out.println("");
            System.out.println("Que desea hacer?");
            System.out.println("1. Ingresar pasajero");
            System.out.println("2. Consultar asiento");
            System.out.println("3. Consultar pasajero");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            int option = Integer.valueOf(this.scanner.nextLine());
            System.out.println("");
            
            if (option == 1) {
                System.out.println("Ingresar pasajero:");
                System.out.print("Ingrese el nombre del pasajero: ");
                String name = this.scanner.nextLine();
                System.out.print("Ingrese el apellido del pasajero: ");
                String lastName = this.scanner.nextLine();
                System.out.print("Ingrese la fila del asiento: ");
                int row = Integer.valueOf(this.scanner.nextLine());
                System.out.print("Ingrese la columna del asiento: ");
                String col = this.scanner.nextLine();
                while (!(this.findSeat(row, col).isFree())) {
                    System.out.println("Asiento ocupado, Ingrese otro asiento");
                    System.out.print("Ingrese la fila del asiento: ");
                    row = Integer.valueOf(this.scanner.nextLine());
                    System.out.print("Ingrese la columna del asiento: ");
                    col = this.scanner.nextLine();
                }
                this.findSeat(row, col).setPassenger(new Passenger(name, lastName));
                System.out.println("Pasajero ingresado!");
                this.plane.addSeats();
            }
            
            if (option == 2) {
                System.out.println("Consulta de asiento.");
                System.out.print("Ingrese la fila del asiento: ");
                int row = Integer.valueOf(this.scanner.nextLine());
                System.out.print("Ingrese la columna del asiento: ");
                String col = this.scanner.nextLine();
                Seat seat = this.findSeat(row, col);
                if (seat.isFree()) {
                    System.out.println("Asiento libre");
                } else {
                    System.out.println("Asiento ocupado. Pasajero: "
                            + seat.getPassenger());
                }
            }
            //codigo incompleto
//            if (option == 3) {
//                System.out.println("Consulta de pasajero.");
//                System.out.print("Ingrese el nombre y apellido: ");
//                String fullName = this.scanner.nextLine();
//                
//                
//            }
            
        }

    }
}
