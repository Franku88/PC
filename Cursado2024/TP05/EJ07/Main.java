package Cursado2024.TP05.EJ07;

public class Main {
    static final int X = 10; //Capacidad de escalera del mirador
    static final int V = 15; //Cantidad de visitantes
    public static void main(String[] args) {
        Mirador mirador = new Mirador(X);
        Encargado encargado = new Encargado("Encargado1", mirador);
        Visitante[] visitantes = new Visitante[V];
        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i] = new Visitante("V"+i, mirador);
        }

        encargado.start();
        for (int i = 0; i < visitantes.length; i++) {
            visitantes[i].start();
        }
    }
}
