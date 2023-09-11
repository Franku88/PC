package TP03.EJ02.OtraForma;

public class EnergiaSinc {
    private int energia = 10;
    private final Object lock = new Object();

    public int getEnergia() {
        synchronized (lock) {
            return this.energia;
        }
    }

    public void drenarEnergia(int cantDrenada) {
        synchronized (lock) {
            energia -= cantDrenada;
            System.out.println("Criatura Oscura drenó "+cantDrenada+" unidades de Energía. Energia: " + this.energia);
        }
    }

    public void revitalizarEnergia(int cantRevitalizada) {
        synchronized (lock) {
            energia += cantRevitalizada;
            System.out.println("Sanador revitalizó "+cantRevitalizada+" unidades de Energía. Energia: " + this.energia);
        }
    }
}