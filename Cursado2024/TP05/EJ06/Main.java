package Cursado2024.TP05.EJ06;

public class Main {
    static final int CANTIDAD = 15; //Aviones
    public static void main(String[] args) {
        Pista pista = new Pista();
        TorreControl torre = new TorreControl("Torre1", pista);
        Avion[] aviones = new Avion[CANTIDAD];
        for (int i = 0; i < aviones.length; i++) {
            aviones[i] = new Avion("AV"+i, pista);
        }

        for (int i = 0; i < aviones.length; i++) {
            aviones[i].start();
        }
        torre.start();
    }
}