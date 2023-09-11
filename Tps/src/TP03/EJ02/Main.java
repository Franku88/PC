package TP03.EJ02;

public class Main {
    public static void main(String[] args) {
        Personaje pj = new Personaje();

        AlteradorEnergia alt1 = new AlteradorEnergia("La Criatura Oscura", -3, pj);
        AlteradorEnergia alt2 = new AlteradorEnergia("El Sanador", 3, pj);

        Thread h1 = new Thread(alt1, "La Criatura Oscura");
        Thread h2 = new Thread(alt2, "El Sanador");

        h1.start();
        h2.start();

    }   
}