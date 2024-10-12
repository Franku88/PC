package Cursado2024.TP03.EJ07;

public class Letra implements Runnable {
    private char letra;
    private int veces;
    private ImpresorLetra impresor;

    public Letra(char letter, int times, ImpresorLetra imp) {
        this.letra = letter;
        this.veces = times;
        this.impresor = imp;
    }

    public void run() {
        while (true) {
            (this.impresor).imprimir(this.letra, this.veces);
        }
    }
}
