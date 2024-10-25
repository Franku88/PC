package Cursado2024.TP05.EJ05;

public class Pasajero extends Thread {
    private Tren gestor;
    
    public Pasajero(String nom, Tren gest) {
        super(nom);
        this.gestor = gest;
    }

    public void run() {
        boolean flag = true;
        while(flag) { //Hasta que no haya tickets
            try {
                flag = this.gestor.comprarTicket();
                if (flag) { //Si habia ticket disponible
                    this.gestor.ocuparAsiento();
                    this.gestor.desocuparAsiento();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
