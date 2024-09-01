package TP02.EJ06;

class Corredor implements Runnable {
    private String nombre;
    private double distancia;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distancia = 0;
    }

    public void avanzar(double dist) {
        this.distancia = this.distancia + dist;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        int i, av;
        System.out.println("Comienza corredor "+this.nombre+".");
        //El corredor da 100 pasos, entre cada paso da un descanso
        for (i = 0; i < 100; i++) {
            av = (int) (Math.random()*10) + 1;
            this.avanzar(av);
            //Espera luego del paso
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            System.out.println("Corredor "+this.nombre+" avanzó "+av+" cm.");
        }
        System.out.println("Corredor "+this.nombre+" ha terminado.");
    }
}

class testCorredor {
    public static void main(String[] args) {
        int i, cantCorredores = 5;
        Corredor[] corredores = new Corredor[cantCorredores];
        Thread[] hilos = new Thread[cantCorredores];

        //Crea corredores y sus respectivos hilos
        for (i = 0; i < cantCorredores; i++) {
            corredores[i] = new Corredor("#"+(i+1));
            hilos[i] = new Thread(corredores[i]);
        }

        //Inicia cada hilo
        for (i = 0; i < cantCorredores; i++) {
            hilos[i].start();
        }

        //Espera a que cada corredor termine
        for (i = 0; i < cantCorredores; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Busca al que recorrio mas distancia
        Corredor ganador = corredores[0];
        for (i = 1; i < cantCorredores; i++) {
            if (ganador.getDistancia() < corredores[i].getDistancia()) {
                ganador = corredores[i];
            }
        }

        System.out.println("Corredor "+ganador.getNombre()+ " ha ganador con "+ganador.getDistancia()+" cm recorridos.");

    }
}

