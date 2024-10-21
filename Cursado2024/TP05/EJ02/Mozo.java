package Cursado2024.TP05.EJ02;

public class Mozo implements Runnable {
    private String nombre;
    private Comedor comedor;

    public Mozo(String nom, Comedor com) {
        this.nombre = nom;
        this.comedor = com;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        while (true) {
            this.comedor.prepararBebida();
        }
    }
}
