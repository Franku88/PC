package TP04.EJ04;

public class Cliente implements Runnable {
    private String nombre;
    private GestorImpresoras gestorImp;

    public Cliente(String nom, GestorImpresoras gestor) {
        this.nombre = nom;
        this.gestorImp = gestor; 
    }

    public void run() {
        solicitarImpresion();
    }

    public void solicitarImpresion() {
        try{
            this.gestorImp.getSemImpresoras().acquire();
            System.out.println("--- Impresora ocupada por "+this.nombre+" ---");
            imprimirDocumento();

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Impresora liberada por "+this.nombre+" ---");
        this.gestorImp.getSemImpresoras().release();
    }

    public void imprimirDocumento() {
        int tiempo = (int) (Math.random()*6)+2;
        try {
            System.out.println(this.nombre+" esta imprimiento. (Espere "+tiempo+" segundos)");
            Thread.sleep(tiempo*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
