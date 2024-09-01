package TP06.EJ07;

public class Auto implements Runnable {
    
    private String patente;
    private MonitorFerry monitor;

    public Auto(String pat, MonitorFerry mon) {
        this.patente = pat;
        this.monitor = mon;
    }

    public void run() {
        while(true) {
            monitor.embarcarAuto(this.patente);
            //Espera a que el ferry inicie y llegue a destino
            monitor.desembarcarAuto(this.patente);
        }
    }
}
