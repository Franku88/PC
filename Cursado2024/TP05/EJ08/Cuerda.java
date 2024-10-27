package Cursado2024.TP05.EJ08;
import java.util.concurrent.Semaphore;

public class Cuerda {
    
    private Semaphore mutex = new Semaphore(1);
    private Semaphore cruzarIzquierda;
    private Semaphore cruzarDerecha;
    private int capacidad;

    private int esperandoIzquierda = 0; //Esperando para cruzar a la izquierda
    private int esperandoDerecha = 0; //Esperando para cruzar a la derecha
    private int cruzando = 0;
    private int cruzoIzquierda = 0;
    private int cruzoDerecha = 0;
    
    public Cuerda(int cap) {
        this.capacidad = cap;
        this.cruzarIzquierda = new Semaphore(cap, true); //Da permiso primero a los que quieren cruzar a la izquierda
        this.cruzarDerecha = new Semaphore(0, true);
    }

    public void iniciarCruceIzquierda() throws InterruptedException {
        //Para que un babuino cruce de derecha a izquierda 
        mutex.acquire();
        this.esperandoIzquierda++;
        mutex.release();

        this.cruzarIzquierda.acquire();
        mutex.acquire();
        this.esperandoIzquierda--;
        this.cruzando++;
        System.out.println(Thread.currentThread().getName()+" COMIENZA CRUCE A IZQUIERDA.");
        mutex.release();
    }

    public void finCruceIzquierda() throws InterruptedException {
        mutex.acquire();
        this.cruzando--;
        this.cruzoIzquierda++;
        System.out.println(Thread.currentThread().getName()+" CRUZO A IZQUIERDA.");
        if (this.cruzando == 0) { //SI NO HAY NADIE CRUZANDO
            if (this.cruzoIzquierda < this.capacidad) { //Si hay permisos aun
                if (this.esperandoIzquierda == 0 && this.esperandoDerecha > 0) { //Pero no hay nadie esperando a cruzar y hay alguien del otro lado
                    System.out.println("NADIE ESPERANDO PARA CRUZAR A IZQUIERDA, DANDO PERMISOS PARA CRUZAR A DERECHA.");
                    this.cruzarIzquierda.acquire(this.capacidad - this.cruzoIzquierda); //Quita permisos restantes
                    this.cruzoIzquierda = 0;
                    this.cruzarDerecha.release(this.capacidad); //Da permisos a los que esperan (da igual el caso, siempre da la capacidad)
                } //Si no hay nadie, no quita permisos ni los da, sigue esperando a que alguien cruce a la izquierda
                mutex.release();
            } else { //Si ya cruzaron this.capacidad cantidad de babuinos a derecha, da permisos a izquierda
                this.cruzoIzquierda = 0;
                System.out.println("SIN PERMISOS, DANDO PERMISOS PARA CRUZAR A DERECHA.");
                this.cruzarDerecha.release(this.capacidad);
                mutex.release();
            }   
        } else {
            mutex.release();
        }
    }

    public void iniciarCruceDerecha() throws InterruptedException {
        //Para que un babuino cruce de izquierda a derecha
        mutex.acquire();
        this.esperandoDerecha++;
        mutex.release();

        this.cruzarDerecha.acquire();
        mutex.acquire();
        this.esperandoDerecha--;
        this.cruzando++;
        System.out.println(Thread.currentThread().getName()+" COMIENZA CRUCE A DERECHA.");
        mutex.release();
    }

    public void finCruceDerecha() throws InterruptedException {
        mutex.acquire();
        this.cruzando--;
        this.cruzoDerecha++;
        System.out.println(Thread.currentThread().getName()+" CRUZO A DERECHA.");
        if (this.cruzando == 0) { //SI NO HAY NADIE CRUZANDO
            if (this.cruzoDerecha < this.capacidad) { //Si hay permisos aun
                if (this.esperandoDerecha == 0 && this.esperandoIzquierda > 0) { //Pero no hay nadie esperando a cruzar y hay alguien del otro lado
                    System.out.println("NADIE ESPERANDO PARA CRUZAR A DERECHA, DANDO PERMISOS PARA CRUZAR A IZQUIERDA.");
                    this.cruzarDerecha.acquire(this.capacidad - this.cruzoDerecha); //Quita permisos restantes
                    this.cruzoDerecha = 0;
                    this.cruzarIzquierda.release(this.capacidad); //Da permisos a los que esperan (da igual el caso, siempre da la capacidad)
                } //Si no hay nadie, no quita permisos ni los da, sigue esperando a que alguien cruce a la derecha
                mutex.release();
            } else { //Si ya cruzaron this.capacidad cantidad de babuinos a derecha, da permisos a izquierda
                this.cruzoDerecha = 0;
                System.out.println("SIN PERMISOS, DANDO PERMISOS PARA CRUZAR A IZQUIERDA.");
                this.cruzarIzquierda.release(this.capacidad);
                mutex.release();
            }   
        } else {
            mutex.release();
        }
    }
}