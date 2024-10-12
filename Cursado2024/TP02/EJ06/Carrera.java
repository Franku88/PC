package Cursado2024.TP02.EJ06;

public class Carrera {
    public static void main(String[] args) {
        Corredor[] corredores = {
            new Corredor("Raigor"),
            new Corredor("Mortred"),
            new Corredor("Nevermore")
        };

        Thread[] hilos = new Thread[corredores.length];
        for (int i = 0; i < corredores.length; i++) { //Asigna hilos
            hilos[i] = new Thread(corredores[i]);
        }

        for (int i = 0; i < hilos.length; i++) { //Inicia hilos
            hilos[i].start();
        }
        System.out.println("Carrera Inciada");

        try {
            for (int i = 0; i < hilos.length; i++) { //Espera que finalicen los hilos
                hilos[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Mensaje del ganador en main
        Corredor ganador = buscaGanador(corredores);
        System.out.println("Ganador: "+ganador.getNombre()+" con "+ganador.getDistancia()+ " recorrido.");
    }

    public static Corredor buscaGanador(Corredor[] corredores) {
        //Busca al que recorrió más distancia de un arreglo de corredores ingresado por parametro
        Corredor ganador = corredores[0];
        for (int i = 1; i < corredores.length; i++) {
            if (ganador.getDistancia() < corredores[i].getDistancia()) {
                ganador = corredores[i];
            }
        }
        return ganador;
    }
}
