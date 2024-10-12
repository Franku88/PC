package Cursado2024.TP03.EJ03;

public class Jaula {
    private Object plato;
    private Object rueda;
    private Object hamaca;

    private Thread platoOwner;
    private Thread ruedaOwner;
    private Thread hamacaOwner;

    private double initialTime;

    public Jaula() {
        this.initialTime = System.currentTimeMillis();
        this.plato = new Object();
        this.rueda = new Object();
        this.hamaca = new Object();
        this.platoOwner = null;
        this.ruedaOwner = null;
        this.hamacaOwner = null;
    }

    public void usarPlato() {
        synchronized (this.plato) {
            synchronized(this) {
                this.platoOwner = Thread.currentThread();
            }
            //System.out.println("(PLATO UNAVAILABLE) \t"+Thread.currentThread().getName().toUpperCase()+" comiendo del plato...");
            estadoJaula();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized(this) {
                this.platoOwner = null;
            }
            //System.out.println("(PLATO AVAILABLE) \t"+Thread.currentThread().getName().toUpperCase()+" deja el plato...");
            //estadoJaula();
        }
    }

    public void usarRueda() {
        synchronized (this.rueda) {
            synchronized(this) {
                this.ruedaOwner = Thread.currentThread();
            }
            //System.out.println("(RUEDA UNAVAILABLE) \t"+Thread.currentThread().getName().toUpperCase()+" corriendo en la rueda...");
            estadoJaula();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized(this) {
                this.ruedaOwner = null;
            }
            //System.out.println("(RUEDA AVAILABLE) \t"+Thread.currentThread().getName().toUpperCase()+" deja la rueda...");
            //estadoJaula();
        }
    }

    public void usarHamaca() {
        synchronized (this.hamaca) {
            synchronized(this) {
                this.hamacaOwner = Thread.currentThread();
            }
            //System.out.println("(HAMACA UNAVAILABLE) \t"+Thread.currentThread().getName().toUpperCase()+" durmiendo en la hamaca...");
            estadoJaula();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized(this) {
                this.hamacaOwner = null;
            }
            //System.out.println("(HAMACA AVAILABLE) \t"+Thread.currentThread().getName().toUpperCase()+" deja la hamaca...");
            //estadoJaula();
        }
    }

    private synchronized void estadoJaula() {
        String enPlato = "   -   ";
        String enRueda = "   -   ";
        String enHamaca = "   -   ";

        if (this.platoOwner != null) {
            enPlato = this.platoOwner.getName();
        }

        if (this.ruedaOwner != null) {
            enRueda = this.ruedaOwner.getName();
        }

        if (this.hamacaOwner != null) {
            enHamaca = this.hamacaOwner.getName();
        }

        System.out.println("P: "+enPlato+"\t"+"R: "+enRueda+"\t"+"H: "+enHamaca+"\t("+((System.currentTimeMillis()-this.initialTime)/1000)+" secs)");
    }
}
