package TP03.EJ03;

public class MainJaula {
    public static void main(String[] args){
        Jaula jaula = new Jaula();

        Hamster ha1 = new Hamster("Riki", jaula);
        Hamster ha2 = new Hamster("Yurnero", jaula);
        Hamster ha3 = new Hamster("Mortred", jaula);

        Thread h1 = new Thread(ha1, ha1.getNombre());
        Thread h2 = new Thread(ha2, ha2.getNombre());
        Thread h3 = new Thread(ha3, ha3.getNombre());

        h1.start();
        h2.start();
        h3.start();
    }
}
