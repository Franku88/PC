package TP04.EJ06;

public class Main {

    final static int CANTIDAD = 5;
    public static void main(String[] args) {
        Taxi taxi = new Taxi("985");
        Taxista taxista = new Taxista(taxi);

        Pasajero[] pasajeros = new Pasajero[CANTIDAD];
        cargarPasajeros(pasajeros, taxi);

        for(int i = 0; i < pasajeros.length; i++){
            Thread h = new Thread(pasajeros[i], "P"+i);
            h.start();
        }

        (new Thread(taxista)).start();

    }

    public static void cargarPasajeros(Pasajero[] arr, Taxi taxi) {
        for (int i = 0; i < arr.length; i++) {
            Pasajero p = new Pasajero(taxi);
            arr[i] = p;
        }
    }
}
