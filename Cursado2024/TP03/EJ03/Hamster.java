package Cursado2024.TP03.EJ03;

public class Hamster implements Runnable {

    private String nombre;
    private Jaula jaula; //Recurso compartido

    public Hamster(String nombre, Jaula j) {
        this.nombre = nombre;
        this.jaula = j;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        System.out.println("Empieza "+this.nombre+".");
        System.out.println();
        for (int i = 0; i < 3; i++) {
            this.jaula.usarHamaca();
            this.jaula.usarPlato();
            this.jaula.usarRueda();
        }
    }
    
}
