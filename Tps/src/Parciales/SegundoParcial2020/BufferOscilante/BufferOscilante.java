package Parciales.SegundoParcial2020.BufferOscilante;

import java.util.concurrent.locks.*;
import java.util.LinkedList;

public class BufferOscilante {
    
    private Lock mutex = new ReentrantLock();
    private LinkedList<Integer> ext = new LinkedList<>();
    private LinkedList<Integer> ins = new LinkedList<>();

    private Condition sacar;

    public BufferOscilante() {
        this.sacar = mutex.newCondition();
    }

    public void sacar() {
        try {
            this.mutex.lock();
            while (this.ext.isEmpty()) {
                if (!this.ins.isEmpty()) {
                    this.swap();
                } else {
                    this.sacar.await();
                }
            }
            int aux = this.ext.poll();
            System.out.println("Se ha quitado "+aux+".");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        this.mutex.unlock();
    }

    public void poner(int elem) {
        this.mutex.lock();
        this.ins.add(elem);
        System.out.println("Se ha insertado "+elem+".");
        this.sacar.signal();
        this.mutex.unlock();
    }

    private void swap() {
        LinkedList<Integer> aux = this.ext;
        this.ext = this.ins;
        this.ins = aux;
        System.out.println("--- Swap realizado ---");
    }
}
