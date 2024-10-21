package Cursado2024.TP05.EJ01;
import java.util.concurrent.Semaphore;

public class GestorPiscina {
    private final int CAPACIDAD = 5;
    private Semaphore mutex;

    public GestorPiscina() {
        this.mutex = new Semaphore(CAPACIDAD);
    }

    public void ocupar() {
        System.out.println("--- "+Thread.currentThread().getName()+" intenta ocupar piscina. ---");
        try {
            this.mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" disfruta de la piscina...");
    }

    public void desocupar() {
        System.out.println("--- "+Thread.currentThread().getName()+" salio de la piscina. ---");
        this.mutex.release();
    }
}
