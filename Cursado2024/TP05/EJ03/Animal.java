package Cursado2024.TP05.EJ03;

public class Animal implements Runnable {
    private String nombre;
    private String especie; //"Perro", "Gato"
    private GestorComedor gestor;

    public Animal(String nom, String esp, GestorComedor gest) {
        this.nombre = nom;
        this.especie = esp;
        this.gestor = gest;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        try {
            switch (this.especie) {
                case "Perro":
                        this.gestor.entrarPerro();
                        this.comer();
                        this.gestor.irsePerro();
                    break;
    
                case "Gato":
                        this.gestor.entrarGato();
                        this.comer();
                        this.gestor.irseGato();
                    break;
                default:
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public void comer() {
        int secs = (int) ((Math.random()*5)+6); //5 a 10 segundos
        try {
            System.out.println(this.nombre+" comiendo durante "+secs+" segundos...");
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.nombre+" termino de comer.");
    }
}
