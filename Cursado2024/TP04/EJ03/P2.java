package Cursado2024.TP04.EJ03;

public class P2 implements Runnable {
    Recurso recurso;

    public P2(Recurso rec) {
        this.recurso = rec;
    }

    public void run() {
        while(true) {
            try {
                this.recurso.getSem2().acquire();
                System.out.println("P2 usando recurso.");
                Thread.sleep(2000);
                this.recurso.getSem1().release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
