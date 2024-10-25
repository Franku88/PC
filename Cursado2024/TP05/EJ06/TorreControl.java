package Cursado2024.TP05.EJ06;

public class TorreControl extends Thread {
    private Pista pista;

    public TorreControl(String nombre, Pista unaPista) {
        super(nombre);
        this.pista = unaPista;
    }

    public void run() {
        while(true) {
            try {
                this.pista.gestionarPista();    
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
