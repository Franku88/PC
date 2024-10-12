package Cursado2024.TP04.EJ06;

public class Pasajero implements Runnable {
    private Taxi taxi;

    public Pasajero(Taxi tax) {
        this.taxi = tax;
    }

    public void run() {
        //Intentara ocupar el taxi
        this.taxi.ocupar();
    }
}