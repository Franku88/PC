package TP06.EJ07;

public class Persona implements Runnable {
    
    private String nombre;
    private MonitorFerry monitor;

    public Persona(String nom, MonitorFerry mon) {
        this.nombre = nom;
        this.monitor = mon;
    }

    public void run() {
        while(true) {
            monitor.embarcarPersona(this.nombre);
            //Espera a que el ferry inicie y llegue a destino
            monitor.desembarcarPersona(this.nombre);
        }
    }
}
