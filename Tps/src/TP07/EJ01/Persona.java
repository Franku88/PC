package TP07.EJ01;

public class Persona implements Runnable {

    private String nombre;
    private boolean esJubilado;
    private GestorSala gestor;

    public Persona(String nom, boolean esJ, GestorSala gest) {
        this.nombre = nom;
        this.esJubilado = esJ;
        this.gestor = gest;
    }

    public void run() {
        while (true) {
            if (this.esJubilado) { 
                this.gestor.entrarSalaJubilado(this.nombre);
                try {
                    Thread.sleep(((int) Math.random()*10 + 1)*1000);    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    this.gestor.salirSala(this.nombre);
                }    
            } else {
                this.gestor.entrarSala(this.nombre);
                try {
                    Thread.sleep(((int) Math.random()*10 + 1)*1000);    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    this.gestor.salirSala(this.nombre);
                }
            }
            try {
                //Espera un tiempo antes de volver intentar entrar
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
