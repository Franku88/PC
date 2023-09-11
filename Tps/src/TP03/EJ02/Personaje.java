package TP03.EJ02;

public class Personaje {
    private int energia = 10;
    private Object lock = new Object();

    public Personaje() {
    }

    public int getEnergia() {
        synchronized (lock) {
            return this.energia;
        }
        
    }

    public boolean modificarEnergia(int modif) {
        synchronized(lock) {
            boolean flag = modif >= 0 || this.energia >= -modif;
            if (flag) {
                this.energia = this.energia + modif;
            } else {
                this.energia = 0;
            }
            System.out.println(Thread.currentThread().getName()+" ha alterado la energia en "+ modif +".");
            System.out.println("Energia actual: "+this.energia);
            return flag;
        }
    }

}
