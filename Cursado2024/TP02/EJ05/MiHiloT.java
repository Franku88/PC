package Cursado2024.TP02.EJ05;

public class MiHiloT extends Thread {
    
    public MiHiloT (String nombre) {
        super(nombre);
    }

    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aquí
    public void run() {
        System.out.println("Comenzando "+this.getName());
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En "+this.getName()+", el recuento "+contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(this.getName() + "Interrumpido.");
        }
        System.out.println("Terminando "+this.getName());
    }
}

