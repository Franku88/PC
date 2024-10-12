package Cursado2024.TP04.EJ05;

import java.util.concurrent.Semaphore;

public class Impresora {
    private String id;
    private char tipo;
    private Semaphore permiso;

    public Impresora(String iden, char type) {
        this.id = iden;
        this.tipo = type;
        this.permiso = new Semaphore(1);
    }

    public String getId() {
        return this.id;
    }

    public char getTipo() {
        return this.tipo;
    }

    public boolean ocupar() {
        boolean flag = this.permiso.tryAcquire();
        if (flag) {
            try {
                int secs = (int)(Math.random()*10)+1;
                System.out.println("--- "+this.id+" ocupada por "+Thread.currentThread().getName()+" ---");
                System.out.println("Imprimiendo en "+this.id+" para "+Thread.currentThread().getName()+", espere "+secs+" segundos...");
                Thread.sleep(secs*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public void esperar() {
        try {
            int secs = (int)(Math.random()*10)+1;
            System.out.println("--- "+this.id+" esperada por "+Thread.currentThread().getName()+" ---");
            this.permiso.acquire();
            System.out.println("--- "+this.id+" ocupada por "+Thread.currentThread().getName()+" ---");
            System.out.println("Imprimiendo en "+this.id+" para "+Thread.currentThread().getName()+", espere "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void desocupar() {
        System.out.println("--- "+this.id+" desocupada por "+Thread.currentThread().getName()+" ---");
        this.permiso.release();
    }
}
