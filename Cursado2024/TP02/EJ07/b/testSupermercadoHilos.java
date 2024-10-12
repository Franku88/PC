package Cursado2024.TP02.EJ07.b;

import Cursado2024.TP02.EJ07.Cliente;

public class testSupermercadoHilos {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Techies", new int[] {2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Timbersaw", new int[] {1, 3, 5, 1, 1});

        CajeroThread cajero1 = new CajeroThread("Alchemist", cliente1, System.currentTimeMillis());
        CajeroThread cajero2 = new CajeroThread("Kunkka", cliente2, System.currentTimeMillis());

        cajero1.start();
        cajero2.start();
    }
    
}
