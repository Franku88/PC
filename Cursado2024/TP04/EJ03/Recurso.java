package Cursado2024.TP04.EJ03;

import java.util.concurrent.Semaphore;

public class Recurso {
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

    public Recurso () {
        this.sem1 = new Semaphore(1);
        this.sem2 = new Semaphore(0);
        this.sem3 = new Semaphore(0);
    }

    public Semaphore getSem1() {
        return this.sem1; 
    }

    public Semaphore getSem2() {
        return this.sem2; 
    }

    public Semaphore getSem3() {
        return this.sem3; 
    }
}
