package Cursado2024.TP05.EJ05;

public class VendedorTickets extends Thread {
    private Tren gestor;

    public VendedorTickets(String nom, Tren gest) {
        super(nom);
        this.gestor = gest;
    }

    public void run() {
        boolean flag = true;
        while(flag) { //Vende hasta que no haya tickets
            try {
                flag = this.gestor.venderTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
