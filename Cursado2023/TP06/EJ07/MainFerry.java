package TP06.EJ07;

public class MainFerry {
    
    public static void main(String[] args) {
        MonitorFerry monitor = new MonitorFerry(6);

        Thread f1 = new Thread(new Ferry(monitor));
        
        Thread a1 = new Thread(new Auto("A1", monitor));
        Thread a2 = new Thread(new Auto("B2", monitor));
        Thread a3 = new Thread(new Auto("C3", monitor));
        Thread p1 = new Thread(new Persona("Ricardo Milos", monitor));
        Thread p2 = new Thread(new Persona("Ricardo Arjona", monitor));
        Thread p3 = new Thread(new Persona("Ricardo Fort", monitor));
        
        a1.start();
        a2.start();
        a3.start();
        p1.start();
        p2.start();
        p3.start();
        f1.start();
    }
}
