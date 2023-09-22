package TP04.EJ05;

import java.util.concurrent.Semaphore;

public class Impresora {
    private String id;
    private char tipo;
    private boolean estado;
    private Semaphore utilizar;
    private Semaphore semEstado;

    public Impresora(String iden, char type) {
        this.id = iden;
        this.tipo = type;
        this.estado = false;
        this.utilizar = new Semaphore(1);
        this.semEstado = new Semaphore(1);
    }

    public void usar() {
        try {
            utilizar.acquire();
            this.estado = true;
            System.out.println("--- "+Thread.currentThread().getName()+" tomo la impresora "+this.id+" ---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dejar() {
        this.estado = false;
        System.out.println("--- "+Thread.currentThread().getName()+" libero la impresora "+this.id+" ---");
        this.utilizar.release();

    }

    public boolean getEstado() {
        boolean state = false;
        try {
            this.semEstado.acquire();
            state = this.estado;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.semEstado.release();
        return state;
    }

    public String getId() {
        return this.id;
    }

    public char getTipo() {
        return this.tipo;
    }
}
