package Cursado2024.TP05.EJ07;

import java.util.concurrent.Semaphore;

public class Mirador {
    
    private Semaphore escalera;
    private Semaphore tobogan = new Semaphore(2);
    private Semaphore avisoEncargado = new Semaphore(0);
    private Semaphore avisoVisitante = new Semaphore(0, true);

    public Mirador(int cap) {
        this.escalera = new Semaphore(cap, true);
    }

    public void asignarTobogan() throws InterruptedException { 
        this.avisoEncargado.acquire(); //Espera que alguien este en fila

        this.tobogan.acquire(); //Espera a que desocupen un tobogan (cuando hay lugar, procede a dar paso a visitante)

        this.avisoVisitante.release(); //Da paso a visitante
    }

    public void hacerFila() throws InterruptedException {
        this.escalera.acquire(); //Busca lugar en escalera (FIFO)

        System.out.println(Thread.currentThread().getName()+" ESPERA EN ESCALERA.");
        this.avisoEncargado.release(); //Avisa a encargado de su espera

        this.avisoVisitante.acquire(); //Espera a que encargado le de paso a tobogan (FIFO)
    }

    public void ocuparTobogan(){
        System.out.println(Thread.currentThread().getName()+" DESOCUPA ESCALERA, OCUPA TOBOGAN...");
        this.escalera.release(); //Desocupa lugar en escalera
    }

    public void desocuparTobogan() {
        System.out.println(Thread.currentThread().getName()+" DESOCUPA TOBOGAN...");
        this.tobogan.release();
    }
}