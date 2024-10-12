package Cursado2024.TP04.EJ04;

import java.util.concurrent.Semaphore;;

public class Impresora {
    private int numero;
    private Semaphore permiso;

    public Impresora(int num){
        this.numero = num;
        this.permiso = new Semaphore(1);
    }

    public boolean ocupar() {
        // Retorna true si pudo ocupar impresora
        boolean exito = false;
        try {
            exito = this.permiso.tryAcquire(); // Intenta ocupar impresora
            if (exito) {
                System.out.println("Impresora "+this.numero+" utilizada por "+Thread.currentThread().getName()+"...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exito;
    }

    public void desocupar() {
        System.out.println("Impresora "+this.numero+" liberada por "+Thread.currentThread().getName()+".");
        this.permiso.release(); // Libera impresora
    }
}
