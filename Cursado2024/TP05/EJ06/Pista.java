package Cursado2024.TP05.EJ06;

import java.util.concurrent.Semaphore;

/*Recurso compartido*/
public class Pista {
    
    private Semaphore mutex = new Semaphore(1);

    private Semaphore pista = new Semaphore(1); //Permiso de pista
    private Semaphore avisoTorre = new Semaphore(0); //gen, para que torre realice su siguiente gestion

    private Semaphore despegar = new Semaphore(0); //gen, para que avion pueda iniciar despegue
    private Semaphore aterrizar = new Semaphore(0); //gen, para que avion puede iniciar aterrizaje
    
    //Se priorizan los aterrizajes
    private int aterrizajes = 0; //Cada 10 aterrizajes, prioriza 1 despegue, luego se reinicia a 0
    private int quiereAterrizar = 0; //Cuenta de aviones en espera
    private int quiereDespegar = 0; //Cuenta de aviones en espera
    
    //Torre
    public void gestionarPista() throws InterruptedException {
        this.avisoTorre.acquire(); //Espera a ser avisado
        
        this.pista.acquire(); //Para gestionar siguiente maniobra, debe estar desocupado
        
        this.mutex.acquire();
        if (this.aterrizajes < 10) { //prioriza aterrizaje mientras no ocurran 10 aterrizajes
            System.out.println("PRIORIZANDO ATERRIZAJE.");
            if (this.quiereAterrizar > 0) { //Si quieren aterrizar
                this.aterrizar.release();
            } else {
                System.out.println("SIN ATERRIZAJES EN ESPERA.");
                this.despegar.release();
            }
        } else { //Si ocurrieron 10 aterrizajes, prioriza 1 despegue
            System.out.println("PRIORIZANDO UN DESPEGUE...");
            if(this.quiereDespegar > 0) { //Si quieren despegar
                this.aterrizajes = 0; //Reinicia contador de aterrizajes
                this.despegar.release();
            } else {
                System.out.println("SIN DESPEGUES EN ESPERA.");
                this.aterrizar.release();
            }
        }
        this.mutex.release();
    }

    //Avion
    public void iniciaDespegue() throws InterruptedException {
        this.mutex.acquire();
        this.quiereDespegar++;
        this.mutex.release();

        this.avisoTorre.release(); //Avisa a la torre necesidad de ocupar pista
        this.despegar.acquire(); //Espera permiso de despegar
        System.out.println("--- PISTA OCUPADA: "+Thread.currentThread().getName()+" INICIA DESPEGUE. ---");
        //Inicia despegue, simular tiempo en el hilo
    }

    public void finDespegue() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" FINALIZA DESPEGUE.");
        this.mutex.acquire();
        this.quiereDespegar--; //Disminuye contador de despegues en espera
        this.mutex.release();
        
        System.out.println("--- PISTA LIBRE. ---");
        this.pista.release(); //Luego de despegar, avisa que esta desocupado
    }
    
    public void iniciaAterrizaje() throws InterruptedException {
        this.mutex.acquire();
        this.quiereAterrizar++;
        this.mutex.release();

        this.avisoTorre.release(); //Avisa a la torre necesidad de ocupar pista
        this.aterrizar.acquire(); //Espera permiso de aterrizar
        //Inicia aterrizaje, simular tiempo en el hilo
        System.out.println("--- PISTA OCUPADA: "+Thread.currentThread().getName()+" INICIA ATERRIZAJE. ---");
    }

    public void finAterrizaje() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" FINALIZA ATERRIZAJE.");
        this.mutex.acquire();
        this.quiereAterrizar--; //Disminuye contador de aterrizajes en espera
        this.aterrizajes++;
        this.mutex.release();

        System.out.println("--- PISTA LIBRE. ---");
        this.pista.release(); //Luego de aterrizar, avisa que esta desocupado
    }

    
}
