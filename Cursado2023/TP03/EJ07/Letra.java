package TP03.EJ07;

public class Letra implements Runnable {
    private char letra;
    private int veces;
    private ImpresorLetra impresor;

    public Letra(char let, int vez, ImpresorLetra imp) {
        this.letra = let;
        this.veces = vez;
        this.impresor = imp;
    }

    public void run() {
        while (true) {
            impresor.imprimir(letra, veces);
        }
    }
}
