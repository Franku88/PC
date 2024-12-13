
import java.util.concurrent.Semaphore;

public class GestorFabrica {
    private Semaphore cajaVino;
    private Semaphore cajaAgua;
    private Semaphore notificar; //Antes de notificar al empaquetador, modifica variable empaquetando
    private Semaphore empaquetar;
    private Semaphore almacen;
    private Semaphore transporte;
    private int eVino; //Espacio caja vino
    private int eAgua; //Espacio caja agua
    private int eAlmacen; //Espacio almacen
    private boolean empaquetando; //true: vino, false: agua

    public GestorFabrica() {
        this.cajaVino = new Semaphore(1);
        this.cajaAgua = new Semaphore(1);
        this.notificar = new Semaphore(1); //Cualquier caja que se llene primero puede notificar a empaquetador
        this.empaquetar = new Semaphore(0); //Necesita llenarse primero una caja
        this.almacen = new Semaphore(0); // Necesita hacerse envio primero (por almacen lleno)
        this.transporte = new Semaphore(0); // Necesita llenarse primero almacen
        this.eVino = 10;
        this.eAgua = 10;
        this.eAlmacen = 10;
        this.empaquetando = true;
    }

    public void embotellarVino(String nombre) throws InterruptedException {
        this.cajaVino.acquire(1);
        System.out.println(nombre+" esta embotellando vino...");
        Thread.sleep(2000);
        this.eVino--;
        System.out.println("Vino embotellado.");
        if(this.eVino == 0) {
            System.out.println("Caja de vino llena, notificando a empaquetador...");
            this.notificar.acquire(); //Si esta desocupado el empaqutador
            this.empaquetando = true; //Avisa caja de vino
            this.empaquetar.release();
        } else {
            this.cajaVino.release();
        }
    }

    public void embotellarAgua(String nombre) throws InterruptedException {
        this.cajaAgua.acquire(1);
        System.out.println(nombre+" esta embotellando agua...");
        Thread.sleep(2000);
        this.eAgua--;
        System.out.println("Agua embotellada.");
        if(this.eAgua == 0) {
            System.out.println("Caja de agua llena, notificando a empaquetador...");
            this.notificar.acquire(); //Si esta desocupado el empaqutador
            this.empaquetando = false; //Avisa caja de agua
            this.empaquetar.release();
        } else {
            this.cajaAgua.release();
        }
    }

    public void empaquetarCaja(String nombre) throws InterruptedException {
        this.empaquetar.acquire();
        if (this.empaquetando) { //Vino
            System.out.println(nombre+" esta empaquetando y guardando caja de vino en almacen");
            Thread.sleep(5000);
            this.eAlmacen--;
            this.eVino = 10;
            System.out.println("Caja de vino almacenada y repuesta.");
        } else { //Agua
            System.out.println(nombre+" esta empaquetando y guardando caja de agua en almacen");
            Thread.sleep(5000);
            this.eAlmacen--;
            this.eAgua = 10;
            System.out.println("Caja de agua almacenada y repuesta.");
        }
        if (this.eAlmacen == 0) {
            System.out.println("Almacen lleno, notificando a transportador...");
            this.transporte.release(); //Avisa a transporte
            this.almacen.acquire(); //Espera a que transporte reparta
        }
        this.notificar.release(); //Permite que otro embotellador solicite empaquetar
    }

    public void repartir() throws InterruptedException {
        this.transporte.acquire(); //Si es notificado de repartir
        System.out.println("Transporte reparte cajas y libera almacen");
        this.eAlmacen = 10;
        this.almacen.release();
    }
    /* Falta implementar hilos y main, pero son intuitivos:
        Embotellador.java
        Empaquetador.java
        Transporte.java
        Main.java */
}
