package Cursado2024.TP03.EJ06;

public class Acumulador {
    private int total;
    
    public Acumulador() {
        this.total = 0;
    }

    public synchronized void sumar(int parcial) {
        this.total = this.total + parcial;
    }

    public synchronized int getTotal() {
        return this.total;
    }

}
