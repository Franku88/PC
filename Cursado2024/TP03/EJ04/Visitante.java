package Cursado2024.TP03.EJ04;

public class Visitante implements Runnable {
    private ParqueTematico parque;
    private String nombre;

    public Visitante(String nom, ParqueTematico par) {
        this.parque = par;
        this.nombre = nom;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        int area = (int) (Math.random()*this.parque.getCantidadAreas());
        this.parque.reservarArea(area);
    }

}
