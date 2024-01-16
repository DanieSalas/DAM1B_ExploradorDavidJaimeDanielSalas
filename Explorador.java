import java.util.Random;

import java.util.Map;

import java.util.HashMap;

public class Explorador {
    // Constants for directions
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    // Position class to represent the current position of the explorer
    public static class Posicion {
        int fila;
        int columna;

        public Posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        // getters and setters
        public int getFila() { return fila; }
        public int getColumna() { return columna; }
        public void setFila(int fila) { this.fila = fila; }
        public void setColumna(int columna) { this.columna = columna; }
    }

    // Class variables
    private String nombre;
    private Posicion posicionActual;

    // Constructor
    public Explorador(String nombre) {
        this.nombre = nombre;
        this.posicionActual = new Posicion(new Random().nextInt(5) + 1, 0);
    }

    // Getters and setters
    public String getNombre() { return nombre; }
    public Posicion getPosicionActual() { return posicionActual; }
    public void setPosicionActual(Posicion posicionActual) { this.posicionActual = posicionActual; }

    // Method to move the explorer
    public void moverse(int direccion) {
        switch (direccion) {
            case UP:
                posicionActual.setFila(posicionActual.getFila() - 1);
                break;
            case DOWN:
                posicionActual.setFila(posicionActual.getFila() + 1);
                break;
            case LEFT:
                posicionActual.setColumna(posicionActual.getColumna() - 1);
                break;
            case RIGHT:
                posicionActual.setColumna(posicionActual.getColumna() + 1);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }


    // Method to check the current position of the explorer
    public int checkPosicion(Mapa mapa) {
        if (mapa.esTrampa(posicionActual)) {
            return 1; // The explorer has fallen into a trap
        } else if (mapa.esTesoro(posicionActual)) {
            return 2; // The explorer has found the treasure
        } else {
            return 0; // The explorer is in a regular position
        }
    }


    // Method to explore the adjacent positions
    public int explorar(Mapa mapa) {
        int trampas = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Skip the current position
                }
                Posicion posicion = new Posicion(posicionActual.getFila() + i, posicionActual.getColumna() + j);
                if (mapa.posTesoro(posicion)) {
                    trampas++;
                }
            }
        }
        return trampas;
    }
}