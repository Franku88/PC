package Cursado2024.TP03.EJ04;

public class Main {

    public static void main(String[] args) {
        
        ParqueTematico pq = new ParqueTematico(3);

        System.out.println("Areas y disponibilidad: ");
        System.out.println(pq.mostrarAreas());

        Visitante[] visitantes = {
            new Visitante("Razor", pq), 
            new Visitante("Io", pq),
            new Visitante("Invoker", pq), 
            new Visitante("Axe", pq),
            new Visitante("Ursa", pq)
        };

        Thread[] hilos = new Thread[visitantes.length];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(visitantes[i], visitantes[i].getNombre());
        }       
            
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        try {
            for (int i = 0; i < hilos.length; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Areas y disponibilidad: ");
        System.out.println(pq.mostrarAreas());
        
    }
}
