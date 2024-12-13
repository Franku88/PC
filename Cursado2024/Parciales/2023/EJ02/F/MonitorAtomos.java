import java.util.concurrent.locks.*;

public class MonitorAtomos {
    private int aDisp; //Agua en recipiente
    private int hDisp; //Hidrogenos en espera
    private int oDisp; //Oxigenos en espera
    private int recipiente; //Limite recipiente
    private Lock mutex = new ReentrantLock();
    private Condition condO;
    private Condition condH;

    public MonitorAtomos(int k) {
        this.recipiente = k;
        this.condH = this.mutex.newCondition();
        this.condO = this.mutex.newCondition();
        this.hDisp = 0;
        this.oDisp = 0;
        this.aDisp = 0;
    }

    public void OListo() throws InterruptedException {
        this.mutex.lock();
        this.oDisp++; //ESTO ESTA MAL PUES ANTES DEBERIA ENTRAR EN EL WHILE, DESPUES SUMAR
        while(this.hDisp < 2 || this.oDisp < 1) { //ADEMAS, ESTA CONDICION DEBERIA CONTEMPLAR SOLO A OXIGENOS
            System.out.println("Oxigeno espera");
            this.condO.await();
        }
        this.condH.signal();
        if (this.hDisp >= 2 && this.oDisp >= 1) {
            this.hDisp = 0;
            this.oDisp = 0;
            this.hacerAgua();
        }
        this.mutex.unlock();
    }

    public void HListo() throws InterruptedException {
        this.mutex.lock();
        this.hDisp++; //Igual que en olisto
        while(this.hDisp < 2 || this.oDisp < 1) { //Igual que en olisto
            System.out.println("Hidrogeno espera");
            this.condH.await(); //Duerme, pero no asegura que lo despierten fuera de este metodo
        }
        if (this.oDisp < 1) {
            this.condO.signal();
        } else {
            if (this.hDisp < 2) {
                this.condH.signal();
            }
        }
        if (this.hDisp >= 2 && this.oDisp >= 1) {
            this.hDisp = 0;
            this.oDisp = 0;
            this.hacerAgua();
        }
        this.mutex.unlock();
    }

    private void hacerAgua() throws InterruptedException {
        this.aDisp++;
        System.out.println("Agua creada");
        if (this.recipiente == this.aDisp) {
            System.out.println("Vaciando recipiente...");
            Thread.sleep(1500);
            System.out.println("Recipiente vacio");
            this.aDisp = 0;

        }
    }




}
