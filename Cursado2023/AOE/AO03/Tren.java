package AOE;

import java.util.concurrent.Semaphore;

public class Tren {
    private int espacio;
    private int libre;

    //Semaforo que permite realizar el viaje
    private Semaphore viajar;
    //Semaforo que permite ocupar un espacio
    private Semaphore ocupar;
    //Permite comprar tickets si no esta viajando o vendiendo
    private Semaphore disponible;

    public Tren (int esp) {
        //esp: espacio del tren
        this.espacio = esp;
        this.libre = esp;
        this.viajar = new Semaphore(0);
        this.ocupar = new Semaphore(1);
        this.disponible = new Semaphore(1);
    }

    public void realizarViaje() {
        //Metodo invocado por el ControlTren, el viaje si el tren esta lleno
        //Tiempo aleatoreo (en segundos) que tardara el viaje
        int secs = (int) (Math.random()*7)+3;
        try {
            //Intenta arrancar, lo hace si el tren esta lleno
            this.viajar.acquire();    
            //Avisa que no esta disponible para comprar tickets
            this.disponible.acquire();
            //Simula tiempo de viaje
            System.out.println("El tren esta viajando, espere "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- Viaje finalizado ---");
        //Vacia el tren
        this.libre = this.espacio;
        //Permite comprar tickets
        this.disponible.release();
        //Permite ocupar el tren
        this.ocupar.release();
        
    }

    public void ocuparLugar() {
        //Metodo invocado por el pasajero, intenta ocupar un lugar
        try {
            this.ocupar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Ocupar un lugar libre
        this.libre--;
        System.out.println(Thread.currentThread().getName()+" ha ocupado el tren.");

        if (this.libre == 0) {
            //Si no quedan espacios, libera un permiso para iniciar viaje
            this.viajar.release();
        } else {
            //Si quedan espacios, libera un permiso para ocupar otro espacio
            this.ocupar.release();
        }   
    }

    public Semaphore getDisponible() {
        return this.disponible;
    }
}
