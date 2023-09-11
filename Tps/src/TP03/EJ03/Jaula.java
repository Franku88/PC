package TP03.EJ03;

public class Jaula {
    private Object plato = new Object();
    private Object rueda = new Object();
    private Object hamaca = new Object();

    public Jaula() {
    }

    public void usarPlato(int secs) {
        synchronized(this.plato) {
            try {
                System.out.println(Thread.currentThread().getName()+" ocupó el plato.");
                Thread.sleep(secs*1000);    
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--- "+Thread.currentThread().getName()+" liberó el plato. ---");
        }
    }

    public void usarHamaca(int secs) {
        synchronized(this.hamaca) {
            try {
                System.out.println(Thread.currentThread().getName()+" ocupó la hamaca.");
                Thread.sleep(secs*1000);    
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("--- "+Thread.currentThread().getName()+" liberó la hamaca. ---");
        }
    }

    public void usarRueda(int secs) {
        synchronized(this.rueda) {
            try {
                System.out.println(Thread.currentThread().getName()+" ocupó la rueda.");
                Thread.sleep(secs*1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("--- "+Thread.currentThread().getName()+" liberó la rueda. ---");
        }
    }

}