package TP07.EJ01;

public class MainMuseo {
    
    public static void main(String[] args) {
        GestorSala gestor = new GestorSala();

        Thread m1 = new Thread(new MedidorTemp(3, gestor));

        Thread[] arr = {
            new Thread(new Persona("Silvia", true, gestor)),
            new Thread(new Persona("Orge", true, gestor)),
            new Thread(new Persona("Jamiroqueue", false, gestor)),
            new Thread(new Persona("FF", false, gestor)),
            new Thread(new Persona("Giye", false, gestor)),
            new Thread(new Persona("CristoRey", true, gestor)),
            new Thread(new Persona("Chacalito", true, gestor)),
            new Thread(new Persona("TilinInsano", false, gestor)),
            new Thread(new Persona("Diamantito 2", false, gestor)),
            new Thread(new Persona("Perro Salchicha", false, gestor)),
            new Thread(new Persona("Peron", true, gestor)),
            new Thread(new Persona("Pele", false, gestor)),
            new Thread(new Persona("Darude Sandstorm", true, gestor)),
            new Thread(new Persona("Revolver Ocelot", true, gestor)),
            new Thread(new Persona("Mikecrack", false, gestor)),
            new Thread(new Persona("Oliva", false, gestor)),
            new Thread(new Persona("Etabaina", false, gestor)),
            new Thread(new Persona("Saramambiche", true, gestor))
        };

        //Inicia medidor y personas
        m1.start();
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }        
    }
}
