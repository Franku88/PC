package Cursado2024.Clasicos.Filosofos.Semaforos.ver1;

public class Main {
    public static void main(String[] args) {
        Tenedor t1 = new Tenedor("1"),
        t2 = new Tenedor("2"),
        t3 = new Tenedor("3"),
        t4 = new Tenedor("4"),
        t5 = new Tenedor("5");

        Filosofo[] filosofos = {
            new Filosofo("Filosofo 1", t1, t5),
            new Filosofo("Filosofo 2", t2, t1),
            new Filosofo("Filosofo 3", t3, t2),
            new Filosofo("Filosofo 4", t4, t3),
            new Filosofo("Filosofo 5", t5, t4)
        };

        Thread[] hilos = new Thread[filosofos.length];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(filosofos[i], filosofos[i].getNombre());
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}