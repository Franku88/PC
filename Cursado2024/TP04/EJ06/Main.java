package Cursado2024.TP04.EJ06;

public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi("985");
        Taxista taxista = new Taxista(taxi);
        Pasajero[] pasajeros = {
            new Pasajero(taxi),
            new Pasajero(taxi),
            new Pasajero(taxi),
        };
        
        Thread[] hilos = new Thread[pasajeros.length];
        for(int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(pasajeros[i], "P"+i);
        }

        for(int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        (new Thread(taxista)).start();
    }
}