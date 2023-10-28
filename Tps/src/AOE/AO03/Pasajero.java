package AOE;

public class Pasajero implements Runnable {
    private String nombre;
    private Tren tren;
    private MaquinaExpendedora expendedora;

    public Pasajero (String nom, Tren t, MaquinaExpendedora e) {
        this.nombre = nom;
        this.tren = t;
        this.expendedora = e;
    }

    public void run() {
        //Intenta viajar infinitamente (para test)
        while (true) {
                try {
                    //Verifica si tren esta disponible
                    this.tren.getDisponible().acquire();    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Compra el ticket
                this.expendedora.venderTicket();
                //Libera compra de tiquet
                this.tren.getDisponible().release();

                //Intenta ocupar el tren
                this.tren.ocuparLugar();

                try{
                    //descansa luego del viaje
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        
        }
    }

    public String getNombre() {
        return this.nombre;
    }
}
