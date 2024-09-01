package TP04.EJ01;

public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
        System.out.println("Contador incrementado.");
    }
    
    public synchronized void decrement() {
        c--;
        System.out.println("Contador decrementado.");
    }
    
    public synchronized int value() {
        System.out.println("Contador: "+c);
        return c;
    }
}
