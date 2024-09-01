package TP06.EJ07;

public class MonitorFerry {
    
    private static final int OCUPA_AUTO = 4; //Espacios que ocupa cada auto
    private static final int OCUPA_PERSONA = 1; //Espacios que ocupa cada persona
    
    private final int limite; //Espacio total del ferry
    private int ocupado; //Espacio ocupado del ferry
    private boolean viajando; //Indica si el ferry esta en viaje
    private boolean enDestino; //Indica si llego a destino

    public MonitorFerry(int lim) {
        this.limite = lim;
        this.ocupado = 0;
        this.viajando = false;
        this.viajando = false;
    }

    public synchronized void embarcarAuto(String patente) {
        try {
            while((this.viajando) || (this.ocupado + OCUPA_AUTO > this.limite)) {
                System.out.println("--- El ferry no esta disponible, el auto "+patente+", debe esperar ---");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(" El auto "+patente+" ha embarcado el ferry.");
            this.ocupado = this.ocupado + OCUPA_AUTO;
            this.notifyAll();
        }
    } 

    public synchronized void embarcarPersona(String nombre) {
        try {
            while((this.viajando)  || (this.ocupado + OCUPA_PERSONA > this.limite)) {
                System.out.println("--- El ferry no esta disponible, el pasajero "+nombre+" debe esperar ---");
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(" El pasajero "+nombre+" ha embarcado el ferry.");
            this.ocupado = this.ocupado + OCUPA_PERSONA;
            this.notifyAll();
        }
    } 

    public synchronized void desembarcarAuto(String patente) {
        try {
            while (!this.viajando || !this.enDestino || (this.ocupado - OCUPA_AUTO < 0)) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("El auto "+patente+" ha desembarcado en destino.");
            this.ocupado = this.ocupado - OCUPA_AUTO;
            this.notifyAll();
        }
    }

    public synchronized void desembarcarPersona(String nombre) {
        try {
            while (!this.viajando || !this.enDestino || (this.ocupado - OCUPA_PERSONA < 0)) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("El pasajero "+nombre+" ha desembarcado en destino.");
            this.ocupado = this.ocupado - OCUPA_PERSONA;
            this.notifyAll();
        }
    }

    public synchronized void iniciarViaje() {
        try {
            while(this.ocupado < this.limite) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("1) El ferry ha iniciado el viaje...");
            this.viajando = true;
        }
    }

    public synchronized void llegarDestino() {
        try {
            while(!this.viajando) {
                this.wait();        
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("2) El ferry ha llegado a destino.");
            this.enDestino = true;
            this.notifyAll();
        }
    }

    public synchronized void partirDestino() { 
        try {
            while(this.ocupado > 0 || !this.enDestino) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("3) El ferry ha partido del destino...");
            this.enDestino = false;
        }
    }

    public synchronized void terminarViaje() {        
        try {
            while (!this.viajando || this.enDestino) {
                this.wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println("4) El ferry ha vuelto del viaje.");
            System.out.println();
            this.viajando = false;
            this.notifyAll();
        }
    }

}
