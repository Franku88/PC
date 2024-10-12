package Cursado2024.TP02.EJ08;

public class testSupermercado {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Techies", new int[] {2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Timbersaw", new int[] {1, 3, 5, 1, 1});

        Cajero cajero1 = new Cajero("Alchemist", cliente1, System.currentTimeMillis());
        Cajero cajero2 = new Cajero("Kunkka", cliente2, System.currentTimeMillis());

        new Thread(cajero1).start();
        new Thread(cajero2).start();
    }
    
}
