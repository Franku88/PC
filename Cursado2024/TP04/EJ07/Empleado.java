package Cursado2024.TP04.EJ07;

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
        this.confiteria.pedir();
    }
}
