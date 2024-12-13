
public class Espacio {
    
    private int h; // cont hidro
    private int o; // cont oxi
    private int agua;
    private int recipiente;
    
    public Espacio(int k) {
        this.recipiente = k;
        this.agua = 0;
        this.h = 0;
        this.o = 0;
    }

    public synchronized void oListo() throws InterruptedException {
        while (this.o == 1) { //Primero verifica que no haya otro atomo esperando
            System.out.println("Se tiene el atomo de oxigeno.");
            this.wait();
        }
        this.o++;
        System.out.println("Sumo 1 atomo de oxigeno");
        this.notify(); //NO NECESARIO?
    }

    public synchronized void hListo() throws InterruptedException {
        while(this.h == 2) {
            System.out.println("Ya tiene 2 atomos de hidrogeno.");
            this.wait();
        }
        this.h++;
        System.out.println("Sumo 1 atomo de hidrogeno");
    }

    public synchronized void hacerAgua() {
        if (this.o == 1 && this.h == 2) {
            this.o = 0;
            this.h = 0;
            this.agua++;
            System.out.println("Se genero un atomo de agua.");
            if (this.recipiente == this.agua) {
                System.out.println("Recipiente lleno, vaciando...");
                this.agua = 0;
            }
            this.notifyAll();
        }
    }
}
