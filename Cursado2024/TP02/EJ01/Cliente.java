package Cursado2024.TP02.EJ01;

public class Cliente extends Thread {
    public void run(){
        System.out.println("Soy "+Thread.currentThread().getName());
        Recurso.uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
    
        };
    };
}