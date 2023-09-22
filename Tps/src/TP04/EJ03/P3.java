package TP04.EJ03;

public class P3 implements Runnable{
    Recurso rec;

    public P3(Recurso r) {
        this.rec = r;
    }

    public void run() {
        try {
            this.rec.getSem3().acquire();
            System.out.println("Iniciando P3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceso3();
        this.rec.getSem2().release();
    }

    public void proceso3() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin proceso 3");
    }
}
