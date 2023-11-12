package TP06.EJ02;

public class MainBiblioteca {

    public static void main(String[] args) {
        GestorSalaEstudio gestor = new GestorSalaEstudio(3);

        Thread h1 = new Thread(new Estudiante("JB", gestor));
        Thread h2 = new Thread(new Estudiante("AC", gestor));
        Thread h3 = new Thread(new Estudiante("FFB", gestor));
        Thread h4 = new Thread(new Estudiante("GND", gestor));
        Thread h5 = new Thread(new Estudiante("CJO", gestor));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}
