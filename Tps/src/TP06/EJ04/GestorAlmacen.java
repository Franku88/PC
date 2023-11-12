package TP06.EJ04;

public class GestorAlmacen {
    
    private final int capacidad;
    private int cantProductos;

    public GestorAlmacen(int cap) {
        this.capacidad = cap;
        this.cantProductos = 0;
    }

    public synchronized void colocarProducto(String nombre) {
        try {
            while (this.cantProductos >= this.capacidad) {
                System.out.println("--- Almacen lleno ("+this.cantProductos+" productos), "+nombre+" debe esperar ---");
                this.wait();
            }
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
        System.out.println(nombre+" ha puesto un producto en el almacen.");
        this.cantProductos++;
        System.out.println("Hay "+this.cantProductos+" productos en el almacen.");
        this.notify();
    }

    public synchronized void retirarProducto(String nombre) {
        try {
            while (this.cantProductos <= 0) {
                System.out.println("--- Almacen vacio, ("+this.cantProductos+" productos), "+nombre+" debe esperar ---");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre+" ha retirado un producto del almacen.");
        this.cantProductos--;
        System.out.println("Hay "+this.cantProductos+" productos en el almacen.");
        this.notify();

    }



}
