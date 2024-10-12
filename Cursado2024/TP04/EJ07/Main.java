package Cursado2024.TP04.EJ07;

public class Main {
    public static void main(String[] args) {
        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo("Jose", confiteria);
        Empleado[] empleados = {
            new Empleado("Juan", confiteria),
            new Empleado("Pedro", confiteria),
            new Empleado("Laura", confiteria),
            new Empleado("Maria", confiteria),
            new Empleado("Eva", confiteria)
        };

        Thread[] hilos = new Thread[empleados.length];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(empleados[i], empleados[i].getId());
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        (new Thread(mozo, mozo.getId())).start();
    }
}
