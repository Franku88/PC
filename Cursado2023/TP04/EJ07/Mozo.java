package TP04.EJ07;

public class Mozo implements Runnable {
    private String id;
    private Confiteria confiteria;

    public Mozo(String iden, Confiteria conf) {
        this.id = iden;
        this.confiteria = conf;
    }

    public String getId() {
        return this.id;
    }

    public void run() {
        //Mientras haya pedidos hechos, los prepara y sirve
        while (true) {
            this.confiteria.prepararPedido();
        }
    }
}
