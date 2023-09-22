package TP04.EJ01;

public class TestCounters {
    
    public static void main(String[] args) {
        SynchronizedCounter c1 = new SynchronizedCounter();
        SynchronizedObjectCounter c2 = new SynchronizedObjectCounter();

        RunnableContador r1 = new RunnableContador(c1, c2);
        RunnableContador r2 = new RunnableContador(c1, c2);

        Thread h1 = new Thread(r1);
        Thread h2 = new Thread(r2);
    
        h1.start();
        h2.start();

    }
}
