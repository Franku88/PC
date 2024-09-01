package TP02.EJ02;

public class MiEjecucion extends Thread {
    public synchronized void  run() {
        ir(); 
    }

    public synchronized void ir() {
        hacerMas();
    }

    public synchronized void hacerMas() {
        System.out.println("En la pila");
    }
}
