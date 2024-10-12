package Cursado2024.TP02.EJ05;

class MiHilo implements Runnable {
    String nombreHilo;
    
    public MiHilo (String nombre) {
        this.nombreHilo = nombre;
    }

    //Punto de entrada del hilo
    //Los hilos comienzan a ejecutarse aquí
    public void run() {
        System.out.println("Comenzando "+this.nombreHilo);
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En "+this.nombreHilo+", el recuento "+contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(this.nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando "+this.nombreHilo);
    }
}
