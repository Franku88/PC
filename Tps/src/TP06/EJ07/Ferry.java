package TP06.EJ07;

public class Ferry implements Runnable {
    private MonitorFerry monitor;

    public Ferry (MonitorFerry mon) {
        this.monitor = mon;
    }

    public void run() {
        while (true) {
            try {
                this.monitor.iniciarViaje();
                Thread.sleep(((int) (Math.random()*5)+3)*1000);
                this.monitor.llegarDestino();

                this.monitor.partirDestino();
                Thread.sleep(((int) (Math.random()*5)+3)*1000);
                this.monitor.terminarViaje();                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
