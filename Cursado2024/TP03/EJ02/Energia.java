package Cursado2024.TP03.EJ02;

public class Energia {
    private int actual;

    public Energia() {
        this.actual = 10;
    }

    public synchronized int getActual() {
        return this.actual;
    }

    public synchronized void setActual(int valor) {
        this.actual = valor;
    }

    public synchronized void alterar(int valor) {
        this.actual = this.actual + valor;
    }
   
}