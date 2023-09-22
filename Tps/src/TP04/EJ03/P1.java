package TP04.EJ03;

public class P1 implements Runnable {
    Recurso rec;

    public P1(Recurso r) {
        this.rec = r;
    }
    
    public void run() {
        try {
            this.rec.getSem1().acquire();
            System.out.println("Iniciando P1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceso1();
        this.rec.getSem3().release();
    }

    public void proceso1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin proceso 1");
    }
}
