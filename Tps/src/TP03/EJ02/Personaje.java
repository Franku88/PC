package TP03.EJ02;

public class Personaje {
    private int energia = 10;

    public Personaje() {
    }

    public int getEnergia() {
        return this.energia;
    }

    public void modificarEnergia(int modif) {
        this.energia = this.energia + modif;
    }

}
