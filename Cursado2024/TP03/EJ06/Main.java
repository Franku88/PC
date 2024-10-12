package Cursado2024.TP03.EJ06;

public class Main {
    
    private static final int CANT_NUMEROS = 50000;
    private static final int K = 35;

    public static void main(String[] args) {
        Acumulador acumulador = new Acumulador();
        int[] numeros = new int[CANT_NUMEROS];

        //Carga arreglo con números
        for (int i = 0; i < CANT_NUMEROS; i++) {
            numeros[i] = (int) ((Math.random()*10)+1);
        }

        //Creo sumadores con sus intervalos a sumar del array
        Sumador[] sumadores = new Sumador[K]; 
        int amplitud = (int) (numeros.length / K);
        for (int i = 0; i < K; i++) {
            int min = i * amplitud;
            int max = min + amplitud - 1;
            if ((max + amplitud) > CANT_NUMEROS) {
                max = (CANT_NUMEROS -1);
            }
            //System.out.println("Min: "+min+ ", Max: "+max);
            sumadores[i] = new Sumador(""+i, min, max, numeros, acumulador);
        }

        //Creo hilos
        Thread[] hilos = new Thread[K];
        for (int i = 0 ; i < K; i++) {
            hilos[i] = new Thread(sumadores[i], sumadores[i].getNombre());
        }

        //Inicio hilos
        for (int i = 0; i < K; i++) {
            hilos[i].start();
        }

        //Espero a que todos los hilos finalicen
        try {
            for (int i = 0; i < K; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total sumado: "+ acumulador.getTotal());

    }
}
