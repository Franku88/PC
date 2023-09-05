package TP02.EJ05;

public class MiHiloThread extends Thread {
    //Al solo tener nombre, MiHiloThread utiliza el constructor de thread directamente
    MiHiloThread (String nombre) {
        super(nombre);
    }

    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aquí
    public void run() {
        System.out.println("Comenzando " + Thread.currentThread().getName());
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + Thread.currentThread().getName() + ", el recuento " + contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(Thread.currentThread().getName() + "Interrumpido.");
        }
        System.out.println("Terminando " + Thread.currentThread().getName());
    }
}

class UsoHilos2 {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        
        // Primero, construye un objeto unHilo.
        MiHiloThread mh1 = new MiHiloThread("#1");
        MiHiloThread mh2 = new MiHiloThread("#2");
        MiHiloThread mh3 = new MiHiloThread("#3");
        // Finalmente, comienza la ejecución del hilo.
        mh1.start();
        mh2.start();
        mh3.start();

        for (int i = 0; i < 25; i++) {
            System.out.print(" .");
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }

        System.out.println("Hilo principal finalizado.");
    }
}