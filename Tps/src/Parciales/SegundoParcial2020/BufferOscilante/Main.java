package Parciales.SegundoParcial2020.BufferOscilante;

public class Main {

    public static void main(String[] args) {
        BufferOscilante buffer = new BufferOscilante();
        
        Thread h1 = new Thread(new HiloExtractor(buffer));
        Thread h2 = new Thread(new HiloExtractor(buffer));
        Thread h3 = new Thread(new HiloInsertor(buffer));
        Thread h4 = new Thread(new HiloInsertor(buffer));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }   
}
