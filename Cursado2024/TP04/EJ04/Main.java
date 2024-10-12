package Cursado2024.TP04.EJ04;

public class Main {
    public static void main(String[] args) {
        GestorImpresoras gestor = new GestorImpresoras(4);

        Cliente[] clientes = {
            new Cliente("Roberta", gestor),
            new Cliente("Tomas", gestor),
            new Cliente("Noah", gestor),
            new Cliente("Hana", gestor),
            new Cliente("Santiago", gestor),
            new Cliente("Margarita", gestor)
        };

        Thread[] hilos = new Thread[clientes.length];
        for(int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(clientes[i], clientes[i].getNombre());
        }
        
        for(int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

    }
}
