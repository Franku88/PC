package Cursado2024.TP04.EJ03;

public class P1 implements Runnable {
    Recurso recurso;

    public P1(Recurso rec) {
        this.recurso = rec;
    }

    public void run() {
        while(true) {
            try {
                this.recurso.getSem1().acquire();
                System.out.println("P1 usando recurso.");
                Thread.sleep(2000);
                this.recurso.getSem3().release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
