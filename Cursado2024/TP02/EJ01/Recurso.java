package Cursado2024.TP02.EJ01;

public class Recurso {
    static void uso() {
        Thread t = Thread.currentThread(); //Obtiene hilo en ejecución, no crea uno nuevo
        System.out.println("En recurso: Soy " + t.getName());
    }
}
