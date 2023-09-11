package TP03.EJ02;

public class Personaje {
    private int energia = 10;

    public Personaje() {
    }

    public int getEnergia() {
        return this.energia;
    }

    public synchronized boolean modificarEnergia(int modif) {
        boolean flag = modif >= 0 || this.energia > -modif;
        if (flag) {
            this.energia = this.energia + modif;
            System.out.println(Thread.currentThread().getName()+" ha alterado la energia en "+ modif +".");
            System.out.println("Energia actual: "+this.energia);
        } else {
            System.out.println("No hay energia. Energia actual: "+this.energia);
        }
        return flag;
    }

}
