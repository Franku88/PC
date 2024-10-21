package Cursado2024.TP05.EJ01;

public class Persona implements Runnable {
    private String nombre;
    private GestorPiscina gestor;
    
    public Persona (String nom, GestorPiscina gest) {
        this.nombre = nom;
        this.gestor = gest;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        //while (true) {
            this.gestor.ocupar();
            try {
                Thread.sleep(5000);    
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gestor.desocupar();
        //}
    }
}
