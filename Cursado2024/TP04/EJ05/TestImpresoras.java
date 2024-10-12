package Cursado2024.TP04.EJ05;
import java.util.Random;

public class TestImpresoras {
    public static void main(String[] args) {
        int cantA = 1, cantB = 1;
        GestorImpresoras gestor = new GestorImpresoras(cantA, cantB);

        Cliente[] clientes = new Cliente[6];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente("Cliente"+i, gestor, ((char) ((new Random()).nextInt(3)+65)));
        }

        Thread[] hilos = new Thread[clientes.length];
        for (int i = 0; i < hilos.length; i++) { //Crea hilos en base a clientes
            hilos[i] = new Thread(clientes[i], clientes[i].getNombre());
        }

        System.out.println("--- Clientes ---");
        for (int i = 0; i < clientes.length; i++) {
            System.out.println(clientes[i].getNombre()+" - Tipo: "+clientes[i].getTipo());
        }
        System.out.println("Impresoras A: "+cantA+", Impresoras B: "+cantB);
        System.out.println();

        for (int i = 0; i < hilos.length; i++) { //Inicia hilos
            hilos[i].start();
        }
    }
}
