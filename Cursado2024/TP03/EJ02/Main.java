package Cursado2024.TP03.EJ02;

public class Main {
    public static void main(String[] args) {
        Energia e = new Energia();

        double initialTime = System.currentTimeMillis();
        Entidad e1 = new Entidad("La Criatura Oscura", -3, e, initialTime);
        Entidad e2 = new Entidad("El Sanador", 3, e, initialTime);

        Thread h1 = new Thread(e1, e1.getNombre());
        Thread h2 = new Thread(e2, e2.getNombre());


        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (Exception eX) {
            eX.printStackTrace();
        }

        System.out.println("Enfrentamiento terminado.");
    }
}
