package Cursado2024.TP05.EJ02;

public class Main {
    public static void main(String[] args) {
        Comedor comedor = new Comedor();
        Cocinero cocinero = new Cocinero("Cocinero1", comedor);
        Mozo mozo = new Mozo("Mozo1", comedor);

        Empleado[] empleados = new Empleado[5];
        for(int i = 0; i < empleados.length; i++) {
            empleados[i] = new Empleado("Empleado"+i, i%3, comedor);
        }

        Thread[] hilos = new Thread[empleados.length];
        for(int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(empleados[i], empleados[i].getNombre());
        }

        (new Thread(cocinero, cocinero.getNombre())).start();
        (new Thread(mozo, mozo.getNombre())).start();
        for(int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }
}
/*
Agregan un cocinero, se mantiene el mozo y ahora hay espacio para 2 empleados.
El mozo se encarga de servir bebidas y el cocinero se encarga de la comida. 
Cuando un empleado desea comer o tomar algo se acerca al comedor. Puede elegir: solo tomar algo,
solo comer, o tomar algo y comer. En este último caso debe ser atendido primero por el
mozo y recién cuando consigue su bebida puede solicitar la comida.
Cuando se acerca al comedor si existe algún lugar libre se queda, e indica al mozo que está
allí para que le sirvan, y espera pacientemente que le sirvan la bebida. Cuando le han
servido, le indican que puede continuar y solicitar la comida al cocinero.
El cocinero prepara la comida y le avisa cuando está lista, mientras el
empleado espera. El empleado come y cuando termina deja el lugar libre y vuelve a
trabajar.
Cuando no hay empleados que atender el cocinero aprovecha a ordenar su cocina y probar
nuevas recetas, y el mozo continúa con su hobby.
a. Identificar los objetos activos y los recursos compartidos en el escenario presentado.
b. Dar una solución utilizando semáforos que modele el comportamiento explicado.
 */
