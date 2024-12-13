import java.util.concurrent.locks.*;;

public class Espacio {
    
    private Lock lockOrden;
    private int cantO;
    private int cantH;
    private Condition condListo;
    private Condition condEspera;
    private Condition condVaciar;
    private int cantVecesAgua;
    private int tope;
    
    public Espacio (int limite) {
        this.lockOrden = new ReentrantLock(true);
        this.cantO = 0;
        this.cantH = 0;
        this.condListo = this.lockOrden.newCondition();
        this.condEspera = this.lockOrden.newCondition();
        this.condVaciar = this.lockOrden.newCondition();
        this.cantVecesAgua = 0;
        this.tope = limite;
    }

    public void oListo() throws InterruptedException {
        this.lockOrden.lock();
        while (this.cantO == 1) {
            System.out.println("Oxigeno debe esperar.");
            this.condEspera.await();
        }
        this.cantO++;
        System.out.println("Ingreso oxigeno.");
        if (this.cantH == 2) {
            this.hacerAgua();
        } else {
            this.condListo.await();
        }
        lockOrden.unlock();
    }

    public void hListo() throws InterruptedException {
        this.lockOrden.lock();
        while (this.cantH == 2) {
            System.out.println("Hidrogeno debe esperar.");
            this.condEspera.await();
        }
        this.cantH++;
        System.out.println("Ingreso hidrogeno.");
        if (this.cantH == 2 && this.cantO == 1) {
            this.hacerAgua();        
        } else {
            this.condListo.await();
        }
        this.lockOrden.unlock();
    }

    private void hacerAgua() {
        this.cantVecesAgua++;
        if (this.cantVecesAgua == this.tope) {
            this.condVaciar.signal();
        }
        System.out.println("Se hizo agua.");
        this.condListo.signalAll(); //Primero despierta a los que estaban listos
        this.cantO = 0;
        this.cantH = 0;
        this.condEspera.signalAll(); //Luego los que no pudieron entrar por tope (H==2 o O==1)
        this.lockOrden.unlock(); //Libera lock ya que desde donde se llama este metodo, aun no se libero (aunque esta de mas creo)
    }

    public void vaciarRecipiente() throws InterruptedException {
        this.lockOrden.lock();
        while (this.cantVecesAgua < this.tope) {
            System.out.println("Aun no se puede vaciar.");
            this.condVaciar.await();
        }
        this.cantVecesAgua = 0;
        System.out.println("Se ha vaciado el recipiente.");
        this.lockOrden.unlock();
    }

    /*Faltan clases:
        Vaciador.java (solo usa vaciarRecipiente dentro de un while)
        Atomo.java (segun tipo (O-H), ejecuta un sleep y luego hListo() u oListo())
        Main.java (igual que en otras implementaciones, un GeneradorAtomos y Vaciador en este caso)
    */
}
