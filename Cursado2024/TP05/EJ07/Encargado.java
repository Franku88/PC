package Cursado2024.TP05.EJ07;

public class Encargado extends Thread {
    private Mirador mirador;

    public Encargado(String nombre, Mirador mirad) {
        super(nombre);
        this.mirador = mirad;
    }

    public void run() {
        while (true) {
            try {
                this.mirador.asignarTobogan();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}