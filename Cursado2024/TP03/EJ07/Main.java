package Cursado2024.TP03.EJ07;

public class Main {
    public static void main(String[] args) {
        ImpresorLetra imp = new ImpresorLetra();

        Thread[] hilos = {
            new Thread(new Letra('A', 4, imp)),
            new Thread(new Letra('B', 2, imp)),
            new Thread(new Letra('C', 5, imp))
        };

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start(); //Atento, usar start()
        }
 
    }
}
