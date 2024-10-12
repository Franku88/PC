package Cursado2024.TP02.EJ07.a;

import Cursado2024.TP02.EJ07.Cliente;

public class Cajero {
    private String nombre;
    
    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println ("EL CAJERO " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
        + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp)/1000 + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + "-> Tiempo: " + 
            (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        } 
        System.out.println("EL CAJERO " + this.nombre +" HA TERMINADO DE PROCESAR " 
        + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public void esperarXsegundos(int segundos) {
        //Duerme hilo durante segundos ingresados
        try {
            Thread.sleep(segundos*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
