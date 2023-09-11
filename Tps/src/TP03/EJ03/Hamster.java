package TP03.EJ03;

public class Hamster implements Runnable {
    private String nombre;
    private Jaula jaula;

    public Hamster(String nom, Jaula jau) {
        this.nombre = nom;
        this.jaula = jau;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        for (int i = 0; i < 1; i++) {
            this.jaula.usarRueda(5);
            this.jaula.usarPlato(3);
            this.jaula.usarHamaca(10);
        }
    }
}