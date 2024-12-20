package Cursado2024.Clasicos.Filosofos.Semaforos.ver2;
import java.util.concurrent.Semaphore;

public class Tenedor {

    private String id;
    private Semaphore mutexMirar; //Si esta en vista de algun filosofo (solo un filosofo puede verlo por vez)
    private Semaphore mutexTomar; //Si esta en posesion de algun filosofo
    
    public Tenedor(String iden) {
        this.id = iden;
        this.mutexMirar = new Semaphore(1);
        this.mutexTomar = new Semaphore(1);
    }

    public String getId() {
        return this.id;
    }

    public boolean mirar() {
        return this.mutexMirar.tryAcquire();
    }

    public void noMirar() {
        this.mutexMirar.release();
    }

    public boolean tomar() {
        boolean flag = this.mutexTomar.tryAcquire();
        if (flag) {
            System.out.println(Thread.currentThread().getName()+" toma tenedor "+this.id);
        }
        return flag;
    }

    public void dejar() {
        System.out.println(Thread.currentThread().getName()+" deja tenedor "+this.id);
        this.mutexTomar.release();
    }
}