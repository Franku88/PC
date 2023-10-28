package AOE;

public class ControlTren implements Runnable {
    private Tren tren;

    public ControlTren(Tren t) {
        this.tren = t;
    }
    
    public void run() {
        //Intenta realizar viajes, lo hara cuando este lleno el tren
        while (true) {
            tren.realizarViaje();
        }
    }
}