package TP02.EJ07;

public class CajeroThread extends Thread {
    private Cliente cliente;
    private long initialTime;

    // Constructor, y métodos de acceso
    public CajeroThread(String nom, Cliente cli, long ini) {
        super(nom);
        this.cliente = cli;
        this.initialTime = ini;
    }

    public void esperarXsegundos(int segs) {
        //Pone en espera el hilo actual en segs segundos
        try {
            Thread.sleep(segs*1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }


    public void run() {
        System.out.println("El cajero " + this.getName() + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }

        System.out.println("El cajero "+this.getName()+" HA TERMINADO DE PROCESAR "+this.cliente.getNombre()+" EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }
}
