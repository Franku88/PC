package Cursado2024.TP04.EJ06;

import java.util.concurrent.Semaphore;

public class Taxi {
    private String id;
    private Semaphore libre; //Permite ocupar taxi
    private Semaphore ocupado; //Avisa a taxista
    private Semaphore finViaje; //Permite finalizar viaje

    public Taxi(String iden) {
        this.id = iden;
        this.libre = new Semaphore(1); //Ocupar taxi
        this.ocupado = new Semaphore(0); //Manejar taxi
        this.finViaje = new Semaphore(0); //Desocupar taxi
    }

    public void ocupar() {
        try {
            this.libre.acquire(); //Intenta ocupar taxi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- "+Thread.currentThread().getName()+" ha ocupado el Taxi "+this.id+" ---");
        this.ocupado.release(); //Avisa que esta ocupado
        try {
            this.finViaje.acquire(); //Finaliza el viaje si se llego a destino
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.libre.release(); //Desocupa taxi
    }

    public void realizarViaje() {
        int secs = (int) (Math.random()*5)+5;
        try {
            this.ocupado.acquire(); //Espera a que este ocupado
            System.out.println("Taxi "+this.id+" ocupado, llegara a destino en "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Taxi "+this.id+" llego a destino ---");
        this.finViaje.release(); //Avisa que termino el viaje
    }
}
