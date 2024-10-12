package Cursado2024.TP02.EJ05;

class UsoHilos{
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");

        //Primero, construye un objeto MiHilo (nombrado como unHilo por alguna razon en el pdf).
        MiHilo mh = new MiHilo("#1");

        //Luego, construye un hilo de ese objeto.
        Thread nuevoHilo = new Thread(mh);

        //Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();

        for (int i = 0; i < 30; i++) {
            System.out.print(" .");
        }

        try { //Espera, permitiendo iniciar (no terminar necesariamente) a nuevoHilo
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }

        System.out.println("Hilo principal finalizado.");
    }
}
