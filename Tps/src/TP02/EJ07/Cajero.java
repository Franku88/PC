package TP02.EJ07;

public class Cajero {
    private String nombre;
    
    // Agregar Constructor, y métodos de acceso
    public Cajero(String nom) {
        this.nombre = nom;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void esperarXsegundos(int segs) {
        //Pone en espera el hilo actual en segs segundos
        try {
            Thread.sleep(segs*1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println ("El cajero " + this.nombre +" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +"seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +"->Tiempo: " + (System.currentTimeMillis() - timeStamp)/1000 + "seg");
        } 
        System.out.println("El cajero " + this.nombre +" HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }
}
