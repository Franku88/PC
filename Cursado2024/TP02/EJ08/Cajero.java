package Cursado2024.TP02.EJ08;

public class Cajero implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;
    
    public Cajero(String nombre, Cliente cliente, long initialT) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialT;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public long getInitialTime() {
        return this.initialTime;
    }

    public void run() {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
        + this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime)/1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " 
            + this.cliente.getNombre() + " -> Tiempo: " + (System.currentTimeMillis() - this.initialTime)/1000 + "seg");
        } 
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR "+ this.cliente.getNombre() + " EN EL TIEMPO: " +
        (System.currentTimeMillis() - this.initialTime)/1000 +"seg");
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


