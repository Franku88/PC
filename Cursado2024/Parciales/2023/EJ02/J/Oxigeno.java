package Cursado2024.Parciales.2023.EJ02.J;

public class Oxigeno implements Runnable {
    private Espacio espacio;

    public Oxigeno (Espacio esp) {
        this.espacio = esp;
    }

    public void run() {
        Thread.sleep((int) (Math.random()+1)*1000);
        this.espacio.oListo();
        this.hacerAgua();
    }
    
}
