package Cursado2024.TP02.EJ07.a;

import Cursado2024.TP02.EJ07.Cliente;

public class testSupermercado {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Techies", new int[] {2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Timbersaw", new int[] {1, 3, 5, 1, 1});
        Cajero cajero1 = new Cajero("Alchemist");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
    }
}
