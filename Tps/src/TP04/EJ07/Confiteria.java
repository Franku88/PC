package TP04.EJ07;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore semLugar;
    private Semaphore semPedido;
    private Semaphore semPedidoListo;

    public Confiteria() {
        this.semLugar = new Semaphore(1);
        this.semPedido = new Semaphore(0);
        this.semPedidoListo = new Semaphore(0);
    }

    public void ocuparLugar() {
        try {
            this.semLugar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Lugar ocupado por "+Thread.currentThread().getName()+" ---");
        hacerPedido();
        comerPedido();
        desocuparLugar();
    }

    public void hacerPedido() {
        int secs = (int)(Math.random()*2)+1;
        try {
            System.out.println(Thread.currentThread().getName()+" eligiendo pedido, espere un momento...");   
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Pedido elegido
        this.semPedido.release();
    }

    public void comerPedido() {
        int secs = (int) (Math.random()*2)+1;
        try {
            this.semPedidoListo.acquire();
            System.out.println(Thread.currentThread().getName()+" comiendo pedido, terminando en "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void desocuparLugar() {
        System.out.println("--- Lugar desocupado ---");
        System.out.println();
        this.semLugar.release();
    }

    public void prepararPedido() {
        int secs = (int) (Math.random()*5)+1;
        try {
            this.semPedido.acquire();
            System.out.println(Thread.currentThread().getName()+" esta preparando el pedido, espere "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Pedido servido ---");
        this.semPedidoListo.release();
    }    
}
