package TP04.EJ03;

public class P2 implements Runnable{
    Recurso rec;

    public P2(Recurso r) {
        this.rec = r;
    }

    public void run() {
        try {
            this.rec.getSem2().acquire();
            System.out.println("Iniciando P2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceso2();
        this.rec.getSem1().release();
    }

    public void proceso2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin proceso 2");
    }
}
