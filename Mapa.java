import java.util.Random;

public class Mapa {
    private int[][] tablero;
    private Posicion posTesoro;

    public Mapa() {
        tablero = new int[10][10];
        inicializarTablero();
        generarTesoro();
    }

    public int[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    private void inicializarTablero() {
        for (int col = 0; col < tablero.length; col++) {
            for (int row = 0; row < tablero[col].length; row++) {
                if (col == 0) {
                    tablero[col][row] = 0;
                } else if (col == tablero.length - 1) {
                    if (new Random().nextInt(10) == 0) {
                        tablero[col][row] = 2;
                        posTesoro = new Posicion(col, row);
                    } else {
                        tablero[col][row] = 0;
                    }
                } else {
                    if (new Random().nextInt(5) == 0) {
                        tablero[col][row] = 1;
                    } else {
                        tablero[col][row] = 0;
                    }
                }
            }
        }
    }

    private void generarTesoro() {
        int col = tablero.length - 1;
        int row = new Random().nextInt(tablero[col].length);
        tablero[col][row] = 2;
        posTesoro = new Posicion(col, row);
    }

    public boolean posTesoro(Explorador.Posicion posicion) {
        return false;
    }

    public boolean esTrampa(Explorador.Posicion posicionActual) {
    return false;}

    public boolean esTesoro(Explorador.Posicion posicionActual) {
    return false;}//
}