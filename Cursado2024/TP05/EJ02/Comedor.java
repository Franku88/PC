package Cursado2024.TP05.EJ02;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore sillas;
    private Semaphore pedidoBebida; //adquiere cuando empieza a preparar, libera cuando se hace pedido
    private Semaphore bebidaLista; //adquiere cuando empieza a esperar pedido, libera cuando pedido listo
    private Semaphore pedidoComida; //adquiere cuando empieza a preparar, libera cuando se hace pedido
    private Semaphore comidaLista; //adquiere cuando empieza a esperar pedido, libera cuando pedido listo

    public Comedor() {
        this.sillas = new Semaphore(2);
        this.pedidoBebida = new Semaphore(0);
        this.bebidaLista = new Semaphore(0);
        this.pedidoComida = new Semaphore(0);
        this.comidaLista = new Semaphore(0);
    }

    public void ocupar() {
        System.out.println(Thread.currentThread().getName()+" espera lugar libre...");
        try {
            this.sillas.acquire();    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- "+Thread.currentThread().getName()+" ocupa silla. ---");
    }

    public void desocupar() {
        System.out.println("--- "+Thread.currentThread().getName()+" desocupa silla. ---");
        this.sillas.release();
    }

    public void pedirBebida() {
        System.out.println("--- "+Thread.currentThread().getName()+" hace pedido de bebida. ---");
        this.pedidoBebida.release();
        try {
            this.bebidaLista.acquire();
            System.out.println("--- "+Thread.currentThread().getName()+" recibio su bebida. ---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pedirComida() {
        System.out.println("--- "+Thread.currentThread().getName()+" hace pedido de comida ---");
        this.pedidoComida.release();
        try {
            this.comidaLista.acquire();
            System.out.println("--- "+Thread.currentThread().getName()+" recibio su comida. ---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pedirBebidaYComida() {
        this.pedirBebida();
        this.pedirComida();
    }

    public void prepararBebida() {
        try {
            this.pedidoBebida.acquire();
            System.out.println(Thread.currentThread().getName()+" esta preparando bebida...");
            Thread.sleep(((int)Math.random()*6+4)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Bebida lista.");
        this.bebidaLista.release();
    }

    public void prepararComida() {
        try {
            this.pedidoComida.acquire();
            System.out.println(Thread.currentThread().getName()+" esta preparando comida...");
            Thread.sleep(((int)Math.random()*6+4)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Comida lista.");
        this.comidaLista.release();
    }
}