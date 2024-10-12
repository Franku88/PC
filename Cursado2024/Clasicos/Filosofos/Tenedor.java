package Cursado2024.Clasicos.Filosofos;
import java.util.concurrent.Semaphore;

public class Tenedor {
    
    private String id;
    private Semaphore mutex;
    
    public Tenedor(String iden) {
        this.id = iden;
        this.mutex = new Semaphore(1);
    }

    public String getId() {
        return this.id;
    }

    public boolean tomar() {
        boolean flag = this.mutex.tryAcquire();
        if (flag) {
            System.out.println(Thread.currentThread().getName()+" toma tenedor "+this.id);
        }
        return flag;
    }

    public void dejar() {
        System.out.println(Thread.currentThread().getName()+" deja tenedor "+this.id);
        this.mutex.release();
    }
}
