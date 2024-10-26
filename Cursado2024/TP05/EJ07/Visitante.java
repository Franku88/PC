package Cursado2024.TP05.EJ07;

public class Visitante extends Thread {
    private Mirador mirador;
    
    public Visitante(String nombre, Mirador mirad) {
        super(nombre);
        this.mirador = mirad;
    }

    public void run() {
        try {
            this.mirador.hacerFila();
            this.mirador.ocuparTobogan();
            this.lanzarse();
            this.mirador.desocuparTobogan();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void lanzarse() throws InterruptedException {
        int secs = (int) (Math.random()*4+2);
        System.out.println(this.getName()+" LANZANDOSE... ("+secs+" segundos)");
        Thread.sleep(secs*1000);
    }
}