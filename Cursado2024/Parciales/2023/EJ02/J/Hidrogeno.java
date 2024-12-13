package Cursado2024.Parciales.2023.EJ02.J;

public class Hidrogeno implements Runnable {
    private Espacio espacio;

    public Hidrogeno (Espacio esp) {
        this.espacio = esp;
    }

    public void run() {
        Thread.sleep((int) (Math.random()+1)*1000);
        this.espacio.hListo();
        this.hacerAgua();
    }
    
}
