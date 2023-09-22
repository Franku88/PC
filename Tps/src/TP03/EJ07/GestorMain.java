package TP03.EJ07;

public class GestorMain {
    
    public static void main(String[] args) {
        ImpresorLetra impresor = new ImpresorLetra();

        Letra letraA = new Letra('A', 3, impresor);
        Letra letraB = new Letra('B', 4, impresor);
        Letra letraC = new Letra('C', 2, impresor);

        Thread hA = new Thread(letraA, "Hilo A");
        Thread hB = new Thread(letraB, "Hilo B");
        Thread hC = new Thread(letraC, "Hilo C");    

        hA.start();
        hB.start();
        hC.start();
    } 

}
