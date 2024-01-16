public class Posicion {
    private int coordenadaFila;
    private int coordenadaCol;

    public Posicion(int coordenadaFila, int coordenadaCol) {
        this.coordenadaFila = coordenadaFila;
        this.coordenadaCol = coordenadaCol;
    }

    public int getCoordenadaFila() {
        return coordenadaFila;
    }

    public int getCoordenadaCol() {
        return coordenadaCol;
    }

    public void setCoordenadaFila(int coordenadaFila) {
        this.coordenadaFila = coordenadaFila;
    }

    public void setCoordenadaCol(int coordenadaCol) {
        this.coordenadaCol = coordenadaCol;
    }

    public boolean esTrampa() {
        return this.coordenadaFila == 0 || this.coordenadaCol == 0 || this.coordenadaFila == 9 || this.coordenadaCol == 9;
    }

    public boolean esTesoro() {
        return this.coordenadaFila == 9 && this.coordenadaCol == 9;
    }
}