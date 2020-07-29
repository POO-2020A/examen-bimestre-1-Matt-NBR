/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen1;

import java.util.Objects;

/**
 *
 * @author MATEO
 */
public class Seat {
    private int row;
    private String col;
    private Passenger passenger;

    public Seat(int row, String col) {
        this.row = row;
        this.col = col;
    }
    
    public boolean isFree() {
        return (this.passenger == null);
    }

    @Override
    public String toString() {
        if (this.isFree()) {
            return "Asiento: " + this.row + this.col + ", libre.";
        } else {
            return "Asiento: " + this.row + this.col + ", ocupado. Pasajero: "
                    + this.passenger.getName() + " " + this.passenger.getLastname();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seat other = (Seat) obj;
        if (this.row != other.row) {
            return false;
        }
        if (!Objects.equals(this.col, other.col)) {
            return false;
        }
        return true;
    }

    public int getRow() {
        return row;
    }

    public String getCol() {
        return col;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    
}
