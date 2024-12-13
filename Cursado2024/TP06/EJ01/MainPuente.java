public class MainPuente {
    public static void main(String[] args) {
        GestorTrafico gestor = new GestorTrafico();

        Thread h1 = new Thread(new Auto("A1", "N", gestor));
        Thread h2 = new Thread(new Auto("A2", "N", gestor));
        Thread h3 = new Thread(new Auto("A3", "S", gestor)); 
        Thread h4 = new Thread(new Auto("A4", "S", gestor));
        Thread h5 = new Thread(new Auto("A5", "S", gestor));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();       
    }
}
