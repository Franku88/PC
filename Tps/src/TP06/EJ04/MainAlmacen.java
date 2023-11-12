package TP06.EJ04;

public class MainAlmacen {
    
    public static void main(String[] args) {
        GestorAlmacen gestor = new GestorAlmacen(5);

        Thread p1 = new Thread(new Productor("Productor 1", gestor));
        Thread p2 = new Thread(new Productor("Productor 2", gestor));
        Thread c1 = new Thread(new Consumidor("Consumidor 1", gestor));
        Thread c2 = new Thread(new Consumidor("Consumidor 2", gestor));

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }

    
}
