package TP04.EJ07;

public class Empleado implements Runnable {
    private String id;
    private Confiteria confiteria;

    public Empleado(String iden, Confiteria conf) {
        this.id = iden;
        this.confiteria = conf;
    }

    public String getId() {
        return this.id;
    }

    public void run() {
        //Si hay lugar, lo ocupa, realiza pedido, espera, come y libera el lugar
        this.confiteria.ocuparLugar();
    }
}
