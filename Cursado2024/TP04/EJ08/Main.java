package Cursado2024.TP04.EJ08;

public class Main {
    public static void main(String[] args) {
        ControladorProduccion controlador = new ControladorProduccion();
        Alternador alternador = new Alternador(controlador);

        Producto[] productos = {
            new Producto('E', controlador),
            new Producto('M', controlador),
            new Producto('E', controlador),
            new Producto('E', controlador),
            new Producto('M', controlador),
            new Producto('E', controlador),
            new Producto('M', controlador),
            new Producto('M', controlador),
            new Producto('E', controlador),
            new Producto('M', controlador),
            new Producto('E', controlador),
            new Producto('M', controlador),
            new Producto('E', controlador),
            new Producto('E', controlador)
        };

        Thread[] hilos = new Thread[productos.length];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(productos[i], productos[i].getTipo()+""+i);
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
        (new Thread(alternador, "Alternador1")).start();
    }
}