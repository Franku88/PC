package TP06.EJ02;

public class Estudiante implements Runnable {
    private String nombre;
    private GestorSalaEstudio gestor;

    public Estudiante(String nom, GestorSalaEstudio gest) {
        this.nombre = nom;
        this.gestor = gest;
    }

    public void run() {
        gestor.ocuparMesa(this.nombre);
        try {
            //Simula estudio
            Thread.sleep(((int) (Math.random()*10)+1)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gestor.desocuparMesa(this.nombre);
    }
}
