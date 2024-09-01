package TP03.EJ04;

public class Visitante implements Runnable {
    private ParqueTematico parque;
    private String nombre;

    public Visitante(String nom, ParqueTematico pq) {
        this.nombre = nom;
        this.parque = pq;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        int areaElegida = (int) ((Math.random()*parque.getCantidadAreas()));
        parque.reservarArea(areaElegida);
    }
    
}
