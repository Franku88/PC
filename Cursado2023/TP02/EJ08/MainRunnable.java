package TP02.EJ08;
import TP02.EJ07.Cliente;

public class MainRunnable {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] {2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[] {1, 3, 5, 1, 1});
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        CajeroRunnable cajero1 = new CajeroRunnable("Cajero 1", cliente1, initialTime);
        CajeroRunnable cajero2 = new CajeroRunnable("Cajero 2", cliente2, initialTime);  
        
        (new Thread(cajero1)).start();
        (new Thread(cajero2)).start();
    }
}
