package Cursado2024.TP02.EJ01;

public class testeoRecurso {
    public static void main (String[] args) {
        Cliente juan = new Cliente();
        Cliente ines = new Cliente();
        
        juan.setName("Juan Lopez");
        ines.setName ("Ines Garcia");
        
        juan.start();
        ines.start();

        Recurso.uso();
    }
}
