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
import java.util.ArrayList;

public class Plane {
    private int rows;
    private int cols;
    private ArrayList<Seat> seats;
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

    public Plane(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.seats = new ArrayList<>();
    }
    
    public void addSeats() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.seats.add(new Seat(i, this.letters[j]));
            }
        }
        for (Seat seat: this.seats) {
            if (!(seat.isFree())) {
                seat.setCol("X");
            }
        }
    }

    @Override
    public String toString() {
        String map = "Este es el mapa del avion:\n";
        for (int i = 0; i < this.rows; i++) {
            map = map + (i + 1) + " ";
            for (Seat seat : this.seats) {
                if (seat.getRow() == i) {
                    map = map + seat.getCol();
                }
            }
            map = map + "\n";
        }
        return map;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
        
    
}
