package TP04.EJ04;

public class TestImpresoras {
    public static void main(String[] args) {
        GestorImpresoras gestor = new GestorImpresoras(1);

        Thread[] hilos = {
            new Thread(new Cliente("Mortred", gestor)), 
            new Thread(new Cliente("Yurnero", gestor)),
            new Thread(new Cliente("Solair", gestor)),
            new Thread(new Cliente("Artorias", gestor)),
            new Thread(new Cliente("Ornstein", gestor))
        };

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
