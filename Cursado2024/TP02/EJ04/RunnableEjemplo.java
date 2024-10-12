package Cursado2024.TP02.EJ04;

public class RunnableEjemplo implements Runnable {
    
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
    
    public static void main (String [] args) {
        new Thread(new RunnableEjemplo(), "Maria Jose").start();
        new Thread(new RunnableEjemplo(), "Jose Maria").start();
        System.out.println("Termina thread main");
    }
}
