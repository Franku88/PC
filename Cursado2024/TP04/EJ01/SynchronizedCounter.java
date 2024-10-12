package Cursado2024.TP04.EJ01;

public class SynchronizedCounter {
    private int c = 0;
    
    public synchronized void increment() {
        c++;
    }
    
    public synchronized void decrement() { //Antes no tenia synchronized
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
