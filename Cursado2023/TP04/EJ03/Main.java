package TP04.EJ03;

public class Main {
    public static void main(String[] args) {
        Recurso r = new Recurso();
        
        P1 p1 = new P1(r);
        P2 p2 = new P2(r);
        P3 p3 = new P3(r);

        Thread h1 = new Thread(p1);
        Thread h2 = new Thread(p2);
        Thread h3 = new Thread(p3);

        h1.start();
        h2.start();
        h3.start();
        
    }
}
