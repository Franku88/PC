package AO03;

public class MaquinaExpendedora {
    private int ticketsVendidos;

    public MaquinaExpendedora() {
        this.ticketsVendidos = 0;
    }

    public synchronized void venderTicket() {
        //Aumenta los tickets vendidos
        this.ticketsVendidos++;
        //Avisa de la venta y muestra el total de tickets vendidos
        System.out.println("--- Ticket vendido a "+Thread.currentThread().getName()+" --- Total vendidos: "+this.ticketsVendidos+" ---");
    }
}
