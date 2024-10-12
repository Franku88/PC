package Cursado2024.TP04.EJ07;
import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore silla;
    private Semaphore pedido;
    private Semaphore pedidoListo;

    public Confiteria() {
        this.silla = new Semaphore(1);
        this.pedido = new Semaphore(0);
        this.pedidoListo = new Semaphore(0);
    }

    public void pedir() {
        try {
            this.silla.acquire(); //Espera silla libre
            System.out.println(Thread.currentThread().getName()+" ocupo silla.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" hizo pedido.");
        this.pedido.release();
        try {
            this.pedidoListo.acquire(); //Espera pedido listo
            System.out.println(Thread.currentThread().getName()+" esta comiendo pedido...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" desocupa silla.");
        this.silla.release();
    }

    public void preparar() {
        try {
            this.pedido.acquire(); //Espera pedido
            System.out.println(Thread.currentThread().getName()+" prepara pedido...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" termino pedido.");
        this.pedidoListo.release();
    }


}
