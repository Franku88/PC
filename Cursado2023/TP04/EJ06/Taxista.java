package TP04.EJ06;

public class Taxista implements Runnable {
    private Taxi taxi;

    public Taxista(Taxi tax) {
        this.taxi = tax;
    }

    public void run() {
        //Intentara realizar viaje
        while(true) {
            //El viaje se realizara cuando el taxi este ocupado
            this.taxi.realizarViaje();
        }
    }

}
