package Cursado2024.TP05.EJ01;

public class Main {
    public static void main(String[] args) {
        GestorPiscina gestor = new GestorPiscina();

        Persona[] personas = new Persona[10];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona("P"+i, gestor);
        }

        Thread[] hilos = new Thread[personas.length];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(personas[i], personas[i].getNombre());
        }
 
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}