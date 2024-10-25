package Cursado2024.TP05.EJ05;

import java.util.concurrent.Semaphore;

public class Tren {
    //USO DE SEMAFOROS PARA PODER OCUPAR (hace acquire) Y PARA AVISAR CUANDO OCUPA (release)
    private Semaphore libre; //Permite ocupar asiento y es liberado al terminar recorrido
    private Semaphore ocupado = new Semaphore(0); //Notifica ocupacion (si permisos=capacidad, inicia tomando todos)
    private Semaphore bajarse = new Semaphore(0); //Avisa cada pasajero que desocupa
    private Semaphore desocupado = new Semaphore(0); //Notifica desocupacion (si permisos=capacidad, termina tomando todos)
    
    private Semaphore mutex = new Semaphore(1); //Para acceder y modificar cantTickets
    private Semaphore vender = new Semaphore(0); //Vendedor recibe pedido de ticket
    private Semaphore ticket = new Semaphore(0); //Pasajero recibe ticket

    private int capacidad; //Asientos totales (constante)
    private int cantRecorridos; //Cantidad de viajes que realiza el tren (constante)
    private int cantTickets; //Tickets (inicia como capacidad*recorridos, luego disminuye hasta 0)

    public Tren(int cap, int rec) {
        this.capacidad = cap;
        this.cantRecorridos = rec;
        this.cantTickets = cap*rec; //cantTickets proporcional a cantRecorridos que realiza el tren
        this.libre = new Semaphore(cap);
    }

    public int getCantRecorridos(){
        return  this.cantRecorridos;
    }

    //Vendedor
    public boolean venderTicket() throws InterruptedException {
        boolean flag = false;

        this.mutex.acquire();
        flag = this.cantTickets > 0;
        this.mutex.release();

        if (flag) {
            this.vender.acquire(); //Espera a que alguien quiera comprar (le de permiso de vender)
            
            this.mutex.acquire();
            this.cantTickets--; //Resta ticket a vender
            this.mutex.release();

            Thread.sleep(200); //Simula un tiempo de venta
            this.ticket.release(); //Da ticket (comprarTicket)
        }
        return flag;
    }

    //Pasajero
    public boolean comprarTicket() throws InterruptedException {
        boolean flag = false;
        
        this.mutex.acquire();
        flag = this.cantTickets > 0;
        this.mutex.release();

        if (flag) { //Deja comprar solo si hay tickets disponibles
            this.vender.release(); //Avisa a vendedor que quiere ticket (venderTicket)
            this.ticket.acquire(); //Espera a vendedor
            System.out.println(Thread.currentThread().getName()+" compro ticket.");
        } else {
            System.out.println(Thread.currentThread().getName()+" no consiguio ticket (sin stock).");
        }
        return flag;
    }

    public void ocuparAsiento() throws InterruptedException {
        this.libre.acquire(); //Espera a tener permiso de ocupar
        System.out.println(Thread.currentThread().getName()+" ocupo asiento.");
        this.ocupado.release(); //Avisa que ocupo lugar (iniciarViaje)
    }
    
    public void desocuparAsiento() throws InterruptedException {
        this.bajarse.acquire(); //Espera a tener permiso de bajarse
        System.out.println(Thread.currentThread().getName()+" desocupo asiento.");
        this.desocupado.release(); //Avisa que se bajo (terminarViaje)
    }

    //Control
    public void iniciarViaje() throws InterruptedException {
        this.ocupado.acquire(this.capacidad); //Debe tener tantos permisos como capacidad (ocuparAsiento)
        System.out.println("Comienza el recorrido");
    }

    public void terminarViaje() throws InterruptedException {
        System.out.println("Finalizo recorrido");
        this.bajarse.release(this.capacidad); //Da permisos para bajarse (desocuparAsiento)
        this.desocupado.acquire(this.capacidad); //Espera a que se bajen todos
        System.out.println("Tren VACIO, pueden subirse nuevamente pasajeros");
        this.libre.release(this.capacidad); //Reinicia permisos (ocuparAsiento)
    }
}