package AOE;

public class Test {
    //Espacio del tren
    static final int ESPACIO = 4;
    //Cantidad de personas
    static final int CANTIDAD = 6;
    public static void main (String[] args) {
        //Crea Tren, recurso compartido entre ControlTren y Pasajeros
        Tren tren = new Tren(ESPACIO);

        //Crea Control de tren
        ControlTren control = new ControlTren(tren);

        //Crea Maquina Expendedora
        MaquinaExpendedora expendedora = new MaquinaExpendedora();

        //Arreglo de pasajeros
        Pasajero[] pasajeros = new Pasajero[CANTIDAD];
        cargarPasajeros(pasajeros, tren, expendedora);

        //Crea hilos de ControlTren
        Thread hControl = new Thread(control);
        //Crea hilos de pasajeros
        Thread[] hPasajeros = new Thread[pasajeros.length];
        for (int i = 0; i < pasajeros.length; i++) {
            hPasajeros[i] = new Thread(pasajeros[i], pasajeros[i].getNombre());
        }

        //Inicia hilos creados
        hControl.start();
        for (int i = 0; i < hPasajeros.length; i++) {
            hPasajeros[i].start();
        }
    }

    public static void cargarPasajeros(Pasajero[] arr, Tren t, MaquinaExpendedora e) {
        //Carga un arreglo de Pasajeros con un Tren y una MaquinaExpendedora en comun
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Pasajero("P"+i, t, e);
        }
    }
}
