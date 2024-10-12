package Cursado2024.TP04.EJ08;

public class Alternador implements Runnable {
    private ControladorProduccion controlador;

    public Alternador(ControladorProduccion controller) {
        this.controlador = controller;
    }

    public void run() {
        //Cada cierto tiempo, alterna lineas de produccion
        while(true) {
            try {
                Thread.sleep(13000); 
                this.controlador.cambiaLineas();    
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
