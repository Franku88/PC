package TP06.EJ02;

public class GestorSalaEstudio {
    
    private final int mesasTotal;
    private int mesasOcupadas;

    public GestorSalaEstudio(int mesasTot) {
        this.mesasTotal = mesasTot;
        this.mesasOcupadas = 0;
    }

    public synchronized void ocuparMesa(String nombre) {
        try {
            while(this.mesasOcupadas >= this.mesasTotal) {
                System.out.println("--- Todas las mesas están ocupadas, "+nombre+" debe esperar ---");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre+" ha ocupado una mesa.");
        this.mesasOcupadas++;
    }

    public synchronized void desocuparMesa(String nombre) {
        System.out.println(nombre+" ha desocupado una mesa.");
        this.mesasOcupadas--;
        this.notifyAll();
    }

}
