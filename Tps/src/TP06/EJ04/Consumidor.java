package TP06.EJ04;

public class Consumidor implements Runnable {

    private GestorAlmacen gestor;
    private String nombre;

    public Consumidor(String nom, GestorAlmacen gest) {
        this.nombre = nom;
        this.gestor = gest;
    }

    public void run() {
        while (true) {
            gestor.retirarProducto(this.nombre);
            try {
                Thread.sleep(((int) (Math.random()*5) +1)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
