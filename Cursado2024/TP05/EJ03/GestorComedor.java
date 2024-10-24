package Cursado2024.TP05.EJ03;

import java.util.concurrent.Semaphore;

public class GestorComedor {
    private Semaphore comederos; //Platos ocupados
    private Semaphore mutex = new Semaphore(1); //Acceso a variables
    private Semaphore accesoPerro = new Semaphore(0); //Permisos para acceder a plato (si no hay, entonces espera)
    private Semaphore accesoGato = new Semaphore(0); //Permisos para acceder a plato (si no hay, entonces espera)
    
    //Para condiciones al irse un animal
    private int platosEnUso = 0; //Flag de turno (cierto punto no habria plato en uso, pues se quedo sin permisos dicha especie)
    private int perrosEsperando = 0; 
    private int gatosEsperando = 0;

    //Para verificar si se llego al limite establecido
    private int perrosQueComieron = 0;
    private int gatosQueComieron = 0;

    //Cantidad de una especie que come hasta cambiar turno
    private int limite; 

    //Para realizar cambio en el caso de que no haya nadie esperando (inicio por ejemplo)
    private boolean noHayGatos = true;
    private boolean noHayPerros = true;

    public GestorComedor(int cap, int lim) {
        this.comederos = new Semaphore(cap);
        this.limite = lim;
    }

    private boolean comedorVacio() {
        //true si no hay perros ni gatos (ni comiendo, ni esperando)
        return this.noHayPerros && this.noHayGatos;
    }

    private synchronized void cambiarTurno(String especie) {
        //Cambia turno de especie al llegar al limite
        if (especie.equals("Perro")) {
            this.accesoPerro.release(this.limite);
            this.noHayPerros = false;
        } else {
            this.accesoGato.release(this.limite);
            this.noHayGatos = false;
        }
    }

    public void entrarPerro() throws InterruptedException {
        this.mutex.acquire();
        if (this.comedorVacio()) {
            this.cambiarTurno("Perro");
        }
        this.perrosEsperando++; //Espera
        this.mutex.release();

        this.accesoPerro.acquire(); //Acceden hasta limite, si no, esperan (da el tiempo donde se realiza el cambio de turno)
        this.comederos.acquire(); //Adquiere comedero
        
        this.mutex.acquire(); //Deja de esperar y ocupa plato
        this.perrosEsperando--;
        this.platosEnUso++;
        this.mutex.release();
    }

    public void entrarGato() throws InterruptedException {
        this.mutex.acquire();
        if (this.comedorVacio()) {
            this.cambiarTurno("Gato");
        }
        this.gatosEsperando++; //Espera
        this.mutex.release();

        this.accesoGato.acquire(); //Acceden hasta limite, si no, esperan (da el tiempo donde se realiza el cambio de turno) 
        this.comederos.acquire(); //Adquiere comedero
        
        this.mutex.acquire(); //Deja de esperar y ocupa plato
        this.gatosEsperando--;
        this.platosEnUso++;
        this.mutex.release();
    }


    public void irsePerro() throws InterruptedException {
        this.mutex.acquire();

        this.perrosQueComieron++; //aumenta contador  
        this.platosEnUso--; //comedero, disminuye contador
        this.comederos.release(); //comedero,libera permiso

        if (this.platosEnUso == 0) { //Si era ultimo en dejar de comer
            if (this.perrosQueComieron%this.limite == 0) {
                if (this.gatosEsperando > 0) {
                    System.out.println("Cambiando a gatos (Se llego a limite de perros)");
                    this.cambiarTurno("Gato"); //Si alcanzo limite de perros y hay gatos esperando
                } else {
                    this.noHayGatos = true;
                    if (this.perrosEsperando > 0) { 
                        this.accesoPerro.release(this.limite); //Si alcanzo limite de perros, no hay gatos esperando y hay perros esperando
                    } else { //Si alcanzo limite de perros, no hay perros ni gatos, termina ejecucion
                        this.noHayPerros = true;
                        System.out.println("NO HAY PERROS NI GATOS ESPERANDO");
                    }
                }
            } else { //Si no llego al limite
                if (this.perrosEsperando == 0) { //Si no llego a limite de perros y no hay perros esperando
                    this.noHayPerros = true;
                    this.accesoPerro.acquire(this.limite-(this.perrosQueComieron%this.limite)); //Quito permisos sobrantes
                    if (this.gatosEsperando > 0) { 
                        System.out.println("Cambiando a gatos (No se llego a limite de perros)");
                        this.cambiarTurno("Gato"); //Si hay gatos esperando
                    } else { //Si no hay nadie esperando
                        this.noHayGatos = true;
                        System.out.println("NO HAY PERROS NI GATOS ESPERANDO");
                    }
                }
            }
        }

        this.mutex.release();
    }

    public void irseGato() throws InterruptedException {
        this.mutex.acquire();

        this.gatosQueComieron++;
        this.platosEnUso--;
        this.comederos.release();

        if (this.platosEnUso == 0) { //Si era ultimo en dejar de comer
            if (this.gatosQueComieron%this.limite == 0) {
                if (this.perrosEsperando > 0) {
                    System.out.println("Cambiando a perros (Se llego a limite de gatos)");
                    this.cambiarTurno("Perro"); //Si llego a limite de gatos y hay perros esperando
                } else {
                    this.noHayPerros = true;
                    if (this.gatosEsperando > 0) {
                        this.accesoGato.release(this.limite); //Si llego a limite de gatos, no hay perros esperando y hay gatos esperando
                    } else { //Si alcanzo limite de gatos, no hay gatos ni perros esperando, termina ejecucion
                        this.noHayGatos = true;
                        System.out.println("NO HAY PERROS NI GATOS ESPERANDO");
                    }
                }
            } else {
                if (this.gatosEsperando == 0) { //Si no llego a limite de gatos y no hay gatos esperando
                    this.noHayGatos = true;
                    this.accesoGato.acquire(this.limite-(this.gatosQueComieron%this.limite)); //Quito permisos sobrantes
                    if (this.perrosEsperando > 0) {
                        System.out.println("Cambiando a perros (No se llego a limite de gatos)");
                        this.cambiarTurno("Perro"); //Si hay perros esperando
                    } else { //Si nadie espera
                        this.noHayPerros = true;
                        System.out.println("NO HAY PERROS NI GATOS ESPERANDO");
                    }
                }
            }
        }

        this.mutex.release();
    }
}