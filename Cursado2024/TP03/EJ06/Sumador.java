package Cursado2024.TP03.EJ06;

public class Sumador implements Runnable {
    private String nombre;
    private Acumulador acumulador;
    private int min;
    private int max;
    private int[] array;

    public Sumador(String nom, int mi, int ma, int[] arr, Acumulador acum) {
        this.nombre = nom;
        this.acumulador = acum;
        this.min = mi;
        this.max = ma;
        this.array = arr;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        int parcial = 0;
        for (int i = this.min; i <= this.max; i++) {
            parcial = parcial + this.array[i];
        }
        System.out.println("Sumador "+this.nombre+" acumula: "+parcial);
        this.acumulador.sumar(parcial);
    }
}
