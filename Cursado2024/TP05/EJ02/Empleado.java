package Cursado2024.TP05.EJ02;

public class Empleado implements Runnable {
    private String nombre;
    private int pedido; //0: bebida, 1: comida, 2: ambas
    private Comedor comedor;

    public Empleado(String nom, int ped, Comedor com) {
        this.nombre = nom;
        this.pedido = ped;
        this.comedor = com;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        this.comedor.ocupar();
        switch (this.pedido) {
            case 0:
                System.out.println(this.nombre+" pedira solo bebida.");
                this.comedor.pedirBebida();
                break;
            case 1:
                System.out.println(this.nombre+" pedira solo comida.");
                this.comedor.pedirComida();
                break;
            case 2:
                System.out.println(this.nombre+" pedira bebida y comida.");
                this.comedor.pedirBebidaYComida();
                break;
            default:
                break;
       }
       this.consumir();
       this.comedor.desocupar();
    }

    public void consumir() {
        try {
            System.out.println(this.nombre+ " consume su pedido...");
            Thread.sleep(((int)Math.random()*5+5)*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
