package Cursado2024.TP04.EJ01;

public class SynchronizedObjectCounter {
    private int c = 0;
    
    public void increment() {
        synchronized (this) { //Antes en lugar de 'this' tenia la variable 'c' (que es primitiva, no objeto)
            c++; // Este elemento debe ser casteado a Integer
        } 
    }

    public void decrement() {
        synchronized (this) {
            c--;
        }
    }

    public int value() {
        synchronized(this) { //Antes no estaba definida el bloque se seccion critica
            return c;
        }
    }

}
