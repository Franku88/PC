package TP04.EJ05;

public class TestImpresoras {
    public static void main(String[] args) {

        Impresora[] a = new Impresora[3];
        Impresora[] b = new Impresora[3];
        cargarImpresoras(a, 'A');
        cargarImpresoras(b, 'B');

        GestorImpresoras gestor = new GestorImpresoras(a, b);

        Cliente[] clientes = new Cliente[6];
        llenarClientes(clientes, gestor);

        mostrarUsers(clientes);        

        iniciarClientes(clientes);
    }

    public static void cargarImpresoras(Impresora[] arr, char type) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Impresora(type+""+i, type);
        }
    }

    public static void llenarClientes(Cliente[] arr, GestorImpresoras gestor) {
        int min = 65, max = 67;
        char tipo;

        for (int i = 0; i < arr.length; i++) {
            tipo = (char) ((Math.random()*(max-min+1))+min);
            arr[i] = new Cliente("Ciente"+i, gestor, tipo);
        }
    }

    public static void iniciarClientes(Cliente[] clientes) {
        Thread[] hilos = new Thread[clientes.length];
        int i;

        //Crea hilos en base a clientes
        for (i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(clientes[i], clientes[i].getNombre());
        }

        //Inicia hilos
        for (i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }

    public static void mostrarUsers(Cliente[] arr){
        System.out.println("--- Clientes ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getNombre()+" - Tipo: "+arr[i].getTipo());
        }
    }


}
