package TP03.EJ02;

public class AlteradorEnergia implements Runnable {
    private String nombre;
    private int revitaliza;
    private Personaje pj;

    AlteradorEnergia (String nom, int rev, Personaje p) {
        this.nombre = nom;
        this.revitaliza = rev;
        this.pj = p;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            this.pj.modificarEnergia(this.revitaliza);            
        }
        
    }
}
