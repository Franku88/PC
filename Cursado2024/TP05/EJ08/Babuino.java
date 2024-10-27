package Cursado2024.TP05.EJ08;

public class Babuino extends Thread {
    private Cuerda cuerda;
    private boolean lado; //false: izquierda, true: derecha

    public Babuino(String unNombre, Cuerda unaCuerda, boolean unLado) {
        super(unNombre);
        this.cuerda = unaCuerda;
        this.lado = unLado;
    }

    public void run() {
        try {
            if (this.lado) {
                this.cuerda.iniciarCruceIzquierda();
                this.cruzar();
                this.cuerda.finCruceIzquierda();
                this.lado = false;
            } else {
                this.cuerda.iniciarCruceDerecha();
                this.cruzar();
                this.cuerda.finCruceDerecha();
                this.lado = true;
            }    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cruzar() throws InterruptedException {
        int secs = 5;
        System.out.println(Thread.currentThread().getName()+" esta cruzando... ("+secs+" segundos)");
        Thread.sleep(secs*1000);
    }
}
