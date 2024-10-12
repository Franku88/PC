package Cursado2024.TP02.EJ06;

public class Corredor implements Runnable {
    private String nombre;
    private double distancia;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distancia = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getDistancia() {
        return this.distancia;
    }

    private void avanzar(double avance) {
        this.distancia = this.distancia + avance;
    }

    public void run() {
        int avance;
        for (int i = 1; i <= 100; i++) {
            avance = (int) (Math.random()*10) + 1;
            this.avanzar(avance);
            System.out.println(i+") "+this.nombre+" avanza "+ avance +".");
            try {    
                Thread.sleep(1); //Descanso
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre +" recorrió "+ this.distancia +".");
    }
}
