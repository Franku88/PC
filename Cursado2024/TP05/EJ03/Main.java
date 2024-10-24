package Cursado2024.TP05.EJ03;

public class Main {
    public static void main(String[] args) {
        GestorComedor gestor = new GestorComedor(5, 7);

        Animal[] gatos = new Animal[10];
        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = new Animal("Gato"+i, "Gato", gestor); 
        }

        Animal[] perros = new Animal[10];
        for (int i = 0; i < gatos.length; i++) {
            perros[i] = new Animal("Perro"+i, "Perro", gestor);
        }

        Thread[] hilos = new Thread[gatos.length + perros.length];
        for(int i = 0; i < gatos.length; i++) {
            hilos[i] = new Thread(gatos[i], gatos[i].getNombre());
        }
        for(int i = gatos.length; i < gatos.length + perros.length; i++) {
            hilos[i] = new Thread(perros[i-gatos.length], perros[i-gatos.length].getNombre());
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}