package TP04.EJ07;

public class MainConfiteria {
    static final int CANTIDAD = 10;
    public static void main(String[] args) {
        Confiteria confiteria = new Confiteria();

        Mozo mozo = new Mozo("Takumi", confiteria);

        Empleado[] empleados = new Empleado[CANTIDAD];
        cargarEmpleados(empleados, confiteria);
        Thread[] hilos = generarHilosEmpleado(empleados);

        //Iniciando runnables
        iniciarHilos(hilos);
        (new Thread(mozo, mozo.getId())).start();
        
    }

    public static void cargarEmpleados(Empleado[] arr, Confiteria conf) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Empleado("Empleado "+i, conf);
        }
    }

    public static Thread[] generarHilosEmpleado(Empleado[] arr) {
        Thread[] hs = new Thread[arr.length];
        for (int i = 0; i < hs.length; i++) {
            hs[i] = new Thread(arr[i], arr[i].getId());
        }
        return hs;
    }

    public static void iniciarHilos(Thread[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }
    }
}
