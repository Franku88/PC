package TP04.EJ01;

public class SynchronizedObjectCounter {
    private int c = 0;

    public void increment() {
        synchronized (this) {
            c++;
            System.out.println("Contador incrementado.");
        } // Este elemento debe ser casteado a Integer
    }

    public void decrement() {
        synchronized (this) {
            c--;
            System.out.println("Contador decrementado.");
        }
    }

    public int value() {
        synchronized(this) {
            System.out.println("Contador: "+c);
            return c;
        }
    }
}
