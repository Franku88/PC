package Cursado2024.TP05.EJ05;

public class ControlTren extends Thread {
    private Tren tren;

    public ControlTren(String nom, Tren train) {
        super(nom);
        this.tren = train;
    }
    
    public void run() {
        int i = 0;
        while(i < this.tren.getCantRecorridos()) {
            try {
                this.tren.iniciarViaje();
                this.viajar();
                this.tren.terminarViaje();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void viajar() throws InterruptedException{
        int secs = (int) (Math.random()*7+4);
        System.out.println("Viajando durante "+secs+" segundos...");
        Thread.sleep(secs*1000);
    }
}
