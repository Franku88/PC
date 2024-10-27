package Cursado2024.TP05.EJ08;

public class Main {
    public static void main(String[] args) {
        Cuerda cuerda = new Cuerda(5);

        Babuino[] babuinos = new Babuino[15];
        for (int i = 0; i < babuinos.length; i++) {
            if (i % 2 == 0) {
                babuinos[i] = new Babuino("B"+i, cuerda, true);
            } else {
                babuinos[i] = new Babuino("B"+i, cuerda, false);
            }
        }

        for (int i = 0; i < babuinos.length; i++) {
            babuinos[i].start();
        }

    }
}