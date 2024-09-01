package TP02.EJ04;

public class RunnableEjemplo implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        System.out.println("Termina thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        RunnableEjemplo maria = new RunnableEjemplo();
        RunnableEjemplo jose = new RunnableEjemplo();
        new Thread(maria, "Maria").start();
        new Thread(jose, "Jose").start();
        System.out.println("Termina thread main");
    }
}

