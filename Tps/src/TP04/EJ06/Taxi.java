package TP04.EJ06;

import java.util.concurrent.Semaphore;

public class Taxi {
    private String id;
    private Semaphore semLibre; //Permite ocupar taxi
    private Semaphore semOcupado; //Avisa a taxista
    private Semaphore semFinViaje; //Permite finalizar viaje

    public Taxi(String iden) {
        this.id = iden;
        this.semLibre = new Semaphore(1);
        this.semOcupado = new Semaphore(0);
        this.semFinViaje = new Semaphore(0);
    }

    public void ocupar() {
        try {
            //Intenta ocupar taxi
            this.semLibre.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Avisa que esta ocupado
        this.semOcupado.release();
        //Finaliza el viaje si se llego a destino
        try {
            this.semFinViaje.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.semLibre.release();
    }

    public void realizarViaje() {
        int secs = (int) (Math.random()*10)+1;
        try {
            this.semOcupado.acquire();
            System.out.println("Taxi "+this.id+" ocupado, llegara a destino en "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.semFinViaje.release();
    }

}
