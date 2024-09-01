package TP03.EJ02;

public class Main {
    public static void main(String[] args) {
        Personaje pj = new Personaje();

        Thread h1 = new Thread(new AlteradorEnergia("La Criatura Oscura", -3, pj), "La Criatura Oscura");
        Thread h2 = new Thread(new AlteradorEnergia("El Sanador", 3, pj), "El Sanador");

        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println("Energia final: "+pj.getEnergia());
    }   
}