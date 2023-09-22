package TP04.EJ01;

public class RunnableContador implements Runnable {
    SynchronizedCounter s1;
    SynchronizedObjectCounter s2;

    public RunnableContador (SynchronizedCounter sinc1, SynchronizedObjectCounter sinc2) {
        this.s1 = sinc1;
        this.s2 = sinc2;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            s1.increment();
            s1.value();
            
            s1.decrement();
            s1.value();

            s1.increment();
            s1.value();
        }
    }    
}
