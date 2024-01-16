import java.util.Random;

import java.util.Map;

import java.util.HashMap;

public class Explorador {

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;


    public static class Posicion {
        int fila;
        int columna;

        public Posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }


        public int getFila() { return fila; }
        public int getColumna() { return columna; }
        public void setFila(int fila) { this.fila = fila; }
        public void setColumna(int columna) { this.columna = columna; }
    }


    private String nombre;
    private Posicion posicionActual;


    public Explorador(String nombre) {
        this.nombre = nombre;
        this.posicionActual = new Posicion(new Random().nextInt(5) + 1, 0);
    }


    public String getNombre() { return nombre; }
    public Posicion getPosicionActual() { return posicionActual; }
    public void setPosicionActual(Posicion posicionActual) { this.posicionActual = posicionActual; }


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



    public int checkPosicion(Mapa mapa) {
        if (mapa.esTrampa(posicionActual)) {
            return 1;
        } else if (mapa.esTesoro(posicionActual)) {
            return 2;
        } else {
            return 0;
        }
    }



    public int explorar(Mapa mapa) {
        int trampas = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
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