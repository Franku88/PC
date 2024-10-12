package Cursado2024.TP04.EJ03;

public class P3 implements Runnable {
    Recurso recurso;

    public P3(Recurso rec) {
        this.recurso = rec;
    }

    public void run() {
        while(true) {
            try {
                this.recurso.getSem3().acquire();
                System.out.println("P3 usando recurso.");
                Thread.sleep(2000);
                this.recurso.getSem2().release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
