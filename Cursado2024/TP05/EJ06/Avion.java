package Cursado2024.TP05.EJ06;

public class Avion extends Thread {
    private Pista pista;

    public Avion(String nombre, Pista unaPista) {
        super(nombre);
        this.pista = unaPista;
    }

    public void run() {
        try {
            this.despegar();

            this.volar();

            this.aterrizar();
        } catch (Exception e) {
            
        }
    }

    public void despegar () throws InterruptedException {
        this.pista.iniciaDespegue();

        System.out.println(this.getName()+" MANIOBRANDO...");
        Thread.sleep(5000);

        this.pista.finDespegue();
    }

    public void volar() throws InterruptedException {
        int secs = (int) (Math.random()*5+6);
        //System.out.println(this.getName()+" volando durante "+secs+" segundos...");
        Thread.sleep(secs*1000);
    }

    public void aterrizar() throws InterruptedException {
        this.pista.iniciaAterrizaje();

        System.out.println(this.getName()+" MANIOBRANDO...");
        Thread.sleep(5000);
        
        this.pista.finAterrizaje();
    }
}
