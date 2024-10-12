package Cursado2024.TP04.EJ08;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {
    private char lineaActiva; //N: norte, O: oeste
    private Semaphore linea; //Acceder y modificar linea de produccion activa
    private Semaphore electrico; //Norte
    private Semaphore mecanico; //Oeste
    
    public ControladorProduccion() {
        this.lineaActiva = 'N'; //Norte por defecto
        this.linea = new Semaphore(1);
        this.electrico = new Semaphore(1);
        this.mecanico = new Semaphore(0);   
    }

    public void llegaElectrico() {
        try {
            this.electrico.acquire(); // Verifica si puede ser ensamblado, si no, espera
            System.out.println("Ensamblando producto electrico "+Thread.currentThread().getName()+"...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producto electrico "+Thread.currentThread().getName()+" listo.");
    }

    public void llegaMecanico() {
        try {
            this.mecanico.acquire(); // Verifica si puede ser ensamblado, si no, espera
            System.out.println("Ensamblando producto mecanico "+Thread.currentThread().getName()+"...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producto mecanico "+Thread.currentThread().getName()+" listo.");
    }

    public void sale() {
        try {
            this.linea.acquire(); //Por si hay un cambio de linea mientras se ensambla
            if (this.lineaActiva == 'N') {
                this.electrico.release();
            } else {
                this.mecanico.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.linea.release(); //Permite cambio de linea luego de salida
    }

    public void cambiaLineas() {
        try {
            this.linea.acquire(); //Por si hay ensamblaje mientras se intenta cambiar
            if (this.lineaActiva == 'N') { //Intercambia linea activa
                System.out.println("- CAMBIANDO LINEA ACTIVA A OESTE -");
                this.lineaActiva = 'O';
                System.out.println("- LINEA OESTE ACTIVADA -");
            } else {
                System.out.println("- CAMBIANDO LINEA ACTIVA A NORTE -");
                this.lineaActiva = 'N';
                System.out.println("- LINEA NORTE ACTIVADA -");
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.linea.release(); //Permite salida luego del cambio (para saber a que linea dar permiso en sale())
    }
}
