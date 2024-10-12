package Cursado2024.TP03.EJ03;

public class Main {
    public static void main(String[] args) {
        Jaula j1 = new Jaula();

        Hamster ham1 = new Hamster("Hoodwink", j1);
        Hamster ham2 = new Hamster("Mireska", j1);
        Hamster ham3 = new Hamster("Viper", j1);

        Thread h1 = new Thread(ham1, ham1.getNombre());
        Thread h2 = new Thread(ham2, ham2.getNombre());
        Thread h3 = new Thread(ham3, ham3.getNombre());

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Jaula desalojada.");
    }
}
