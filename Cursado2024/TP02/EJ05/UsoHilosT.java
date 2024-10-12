package Cursado2024.TP02.EJ05;

class UsoHilosT {
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");

        //Primero, construye un objeto MiHilo (nombrado como unHilo por alguna razon en el pdf).
        MiHiloT mh1 = new MiHiloT("#1");
        MiHiloT mh2 = new MiHiloT("#2");
        MiHiloT mh3 = new MiHiloT("#3");

        //Finalmente, comienza la ejecución del hilo.
        mh1.start();
        mh2.start();
        mh3.start();

        for (int i = 0; i < 30; i++) {
            System.out.print(" .");
        }

        try { //Espera, permitiendo iniciar (no terminar necesariamente) a mh
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }

        System.out.println("Hilo principal finalizado.");
    }
}
