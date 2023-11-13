package TP07.EJ01;

public class MedidorTemp implements Runnable {
    
    private GestorSala gestor;
    private int segundos;

    public MedidorTemp(int secs, GestorSala gest) {
        this.segundos = secs;
        this.gestor = gest;
    }

    public void run() {
        while(true) {
            try {
                //Espera tiempo determinado para volver a notificar temperatura
                Thread.sleep(this.segundos*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Notifica temperaturas entre 25°C y 35°C
            this.gestor.notificarTemperatura((int) (Math.random()*10)+26);
        }
    }
}
