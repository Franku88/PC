package Cursado2024.TP05.EJ05;

public class Main {
    static final int CAPACIDAD = 5; //Capacidad tren
    static final int RECORRIDOS = 2;
    static final int NUMERO = 10; //Pasajeros (N>C)
    
    public static void main(String[] args) {
        Tren tren = new Tren(CAPACIDAD, RECORRIDOS); //Recurso
        ControlTren control = new ControlTren("Control1", tren); //Inicia y termina viaje
        VendedorTickets vendedor = new VendedorTickets("Vendedor1", tren); //Vende tickets a pasajeros
        Pasajero[] pasajeros = new Pasajero[NUMERO];
        for(int i = 0; i < pasajeros.length; i++){
            pasajeros[i] = new Pasajero("Pasajero"+i, tren);
        }

        control.start();
        vendedor.start();
        for(int i = 0; i < pasajeros.length; i++){
            pasajeros[i].start();
        }
    }
}