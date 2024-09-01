import java.util.Queue;
import java.util.LinkedList;

public class GestorTrafico {
    
    private int cruzandoNorte;
    private int cruzandoSur;
    private Queue<String> colaNorte = new LinkedList<>();
    private Queue<String> colaSur = new LinkedList<>();

    public GestorTrafico() {
        this.cruzandoNorte = 0;
        this.cruzandoSur = 0;
    }

    public synchronized void entrarCocheDelNorte(String patente) {
        try {
            while (this.cruzandoSur != 0) {
                System.out.println("--- "+patente+" debe esperar para cruzar ---");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(patente+" comienza a cruzar desde el norte");
        this.cruzandoNorte++;
        this.colaNorte.add(patente);
    }

    public synchronized void salirCocheDelNorte(String patente) {
        while(this.colaNorte.peek() != patente) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(patente+" termino de cruzar");
        this.cruzandoNorte--;
        this.colaNorte.poll();
        this.notifyAll();
    }

    public synchronized void entrarCocheDelSur(String patente) {
        try {
            while (this.cruzandoNorte != 0) {               
                System.out.println("--- "+patente+" debe esperar para cruzar ---");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(patente+" comienza a cruzar desde el sur");
        this.cruzandoSur++;
        this.colaSur.add(patente);
    }

    public synchronized void salirCocheDelSur(String patente) {
        while(this.colaSur.peek() != patente) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(patente+" termino de cruzar");
        this.cruzandoSur--;
        this.colaSur.poll();
        this.notifyAll();
    }
}
