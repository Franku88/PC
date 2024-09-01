package TP07.EJ01;

import java.util.concurrent.locks.*;

public class GestorSala {

    private final Lock ingreso = new ReentrantLock();
    private final int tUmbral = 30; // umbral de temperatura para cambio de limite

    private final Condition hayLugar; // Condicion para no jubilado
    private final Condition hayLugarJ; // Condicion para jubilados

    private int jEnEspera; //cantidad de jubilados en espera
    private int limite; //limite de ocupantes
    private int limiteN; //Limite normal
    private int limiteA; //Limite anormal, cuando la temp esta sobre umbral
    private int cantidad; //cantidad de ocupantes actual

    public GestorSala() {
        this.limiteN = 10;
        this.limiteA = 5;
        this.limite = this.limiteN;

        this.cantidad = 0;
        this.jEnEspera = 0;
        this.hayLugar = this.ingreso.newCondition();
        this.hayLugarJ = this.ingreso.newCondition();
    }

    public void entrarSala(String nombre) {
        try {
            this.ingreso.lock();
            while (this.cantidad >= this.limite || this.jEnEspera > 0) {
                System.out.println("--- Sala llena, "+nombre+" debe esperar ("+this.cantidad+"/"+this.limite+", Jub esperando: "+this.jEnEspera+") ---");
                this.hayLugar.await();
            }
            this.cantidad++;
            System.out.println("I) "+nombre+" ha ingresado. ("+this.cantidad+"/"+this.limite+", Jub esperando: "+this.jEnEspera+")"); //I) por ingreso
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.ingreso.unlock();
        }
        
    }

    public void entrarSalaJubilado(String nombre) {
        try {
            this.ingreso.lock();
            this.jEnEspera++;
            while(this.cantidad >= this.limite) {
                System.out.println("--- Sala llena, "+nombre+" debe esperar (Jubilado) ("+this.cantidad+"/"+this.limite+", Jub esperando: "+this.jEnEspera+") ---");
                this.hayLugarJ.await();
            }
            this.jEnEspera--;
            this.cantidad++;
            System.out.println("I) "+nombre+" ha ingresado. (Jubilado) ("+this.cantidad+"/"+this.limite+", Jub esperando: "+this.jEnEspera+")"); //I) por ingreso
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.ingreso.unlock();
        }
    }
    
    public void salirSala(String nombre) {
        this.ingreso.lock();
        this.cantidad--;
        System.out.println("E) "+nombre+" sale de la sala. ("+this.cantidad+"/"+this.limite+", Jub esperando: "+this.jEnEspera+")"); //E) por egreso
        if (this.jEnEspera == 0) {
            this.hayLugar.signal();
        } else {
            this.hayLugarJ.signal();
        }
        this.ingreso.unlock();
    }


    public void notificarTemperatura(int temperatura) {
        this.ingreso.lock();
        System.out.println();
        System.out.print("--- Temperatura actual: ("+temperatura+"°C), ");
        if (temperatura > this.tUmbral) {
            this.limite = this.limiteA;
            System.out.println("esta sobre el umbral ("+this.tUmbral+"°C), limite de personas actual: "+this.limite+" ---");
        } else {
            this.limite = this.limiteN;
            System.out.println("esta por debajo del umbral ("+this.tUmbral+"°C), limite de personas actual: "+this.limite+" ---");
        }
        this.ingreso.unlock();
    }
}